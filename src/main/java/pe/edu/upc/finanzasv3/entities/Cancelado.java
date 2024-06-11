package pe.edu.upc.finanzasv3.entities;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "Cancelado")
public class Cancelado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCancelado;
    @Column(name = "montoCancelado", nullable = true  )
    private float montoCancelado;
    @Column(name = "interes", nullable = true  )
    private float interes;
    @Column(name = "fechaCancelado", nullable = true  )
    private LocalDate fechaCancelado;
    @Column(name = "interesMoratorio", nullable = true  )
    private float interesMoratorio;
    @Column(name = "deudaRestante", nullable = true  )
    private float deudaRestante;

    @ManyToOne
    @JoinColumn(name = "idFactura")
    private Factura factura;

    public Cancelado() {
    }

    public Cancelado(int idCancelado, float montoCancelado, float interes, LocalDate fechaCancelado, float interesMoratorio, float deudaRestante, Factura factura) {
        this.idCancelado = idCancelado;
        this.montoCancelado = montoCancelado;
        this.interes = interes;
        this.fechaCancelado = fechaCancelado;
        this.interesMoratorio = interesMoratorio;
        this.deudaRestante = deudaRestante;
        this.factura = factura;
    }

    //FUNCIONES
    public int calcularDiasTranscurridos( ) {
        int periodoo;
        LocalDate fechaFactura = factura.getFechaFactura();
        Period periodo = Period.between(fechaFactura, fechaCancelado);
        periodoo = fechaCancelado.getDayOfMonth() + ((periodo.getMonths()*30)- fechaFactura.getDayOfMonth());
        return periodoo;
    }

    public void calcularDeuda( ){

        double capital = factura.getMontoPrestamo();
        if (factura.getFechaFactura()==fechaCancelado){
            montoCancelado = factura.getMontoPrestamo();
            
        }else {
            factura.setEstadoFactura("Cancelado");
        }

        double tasa = factura.getTasa()/100;
        double tasaM = factura.getTasaMoratoria()/100;
        double tiempo = calcularDiasTranscurridos();
        float deuda = factura.getDeudaPendiente();
        float diferencia = (float) (factura.getPlazoPago()-tiempo);

        switch (factura.getTipoTasa()) {
            case "Tasa efectiva del periodo":
                if (factura.getFechaFactura()!=fechaCancelado){
                    deuda = (float) calcularTasaEfectivaDelPeriodo(capital,tasa,tiempo);
                }
                factura.setPeriodoActual(factura.getPeriodoActual()+1);
                interes = (float) (deuda-capital);
                break;
            case "Tasa de interes simple":
                factura.setPeriodoActual(factura.getPeriodoActual()+1);
                interes = (float) factura.getInteresFactura();
                break;

            case "Anualidad simple adelantada", "Anualidad simple vencida":
                factura.setPeriodoActual(factura.getPeriodoActual()-1);
                deuda = (float) calcularTasaEfectivaDelPeriodo(capital,tasa,tiempo);
                interes = (float) factura.getInteresFactura();
                break;
        }
        if (diferencia<0) {
            interesMoratorio = (float) calculoDeMora(capital, tasaM, tiempo);
            deuda = deuda + (float) (calculoDeMora(capital, tasaM, tiempo));
            factura.setEstadoFactura("Cancelacion Tardia");
        }

        deuda = deuda - montoCancelado;
        factura.setDeudaPendiente(deuda);
        deudaRestante = deuda;
    }

    /////////
    private double calculoDeMora(double capital, double tasa, double tiempo){
        double mora = 0;
        double a = (1+(tasa));
        double b = (tiempo-factura.getPlazoPago())/factura.getPeriodoTasa();
        mora = capital*(Math.pow(a, b)-1);
        return mora;
    }
    private double calcularTasaEfectivaDelPeriodo(double capital, double tasa, double tiempo){
        double ra =0;
        double a = 1+(tasa);
        double b = tiempo/factura.getPeriodoTasa();
        ra= capital*Math.pow(a,b);
        return ra;
    }

    private double calcularAnualidadSimpleAdelantada(double capital, double tasa, double tiempo){
        double ra =0;
        double  NperiodoRenta = Math.floor(tiempo/7);
        ra = capital * ((tasa*(Math.pow((1+tasa), NperiodoRenta-1)))/((Math.pow((1+tasa),tiempo))-1));
        return ra;
    }

    private double calcularAnualidadSimpleVencida(double capital, double tasa, double tiempo){
        double ra =0;
        double  NperiodoRenta = Math.floor(tiempo/7);
        ra = capital * ((tasa*(Math.pow((1+tasa), NperiodoRenta)))/((Math.pow((1+tasa),tiempo))-1));
        return ra;
    }

    public float getDeudaRestante() {
        return deudaRestante;
    }

    public void setDeudaRestante(float deudaRestante) {
        this.deudaRestante = deudaRestante;
    }

    public int getIdCancelado() {
        return idCancelado;
    }

    public void setIdCancelado(int idCancelado) {
        this.idCancelado = idCancelado;
    }

    public float getMontoCancelado() {
        return montoCancelado;
    }

    public void setMontoCancelado(float montoCancelado) {
        this.montoCancelado = montoCancelado;
    }

    public float getInteres() {
        return interes;
    }

    public void setInteres(float interes) {
        this.interes = interes;
    }

    public LocalDate getFechaCancelado() {
        return fechaCancelado;
    }

    public void setFechaCancelado(LocalDate fechaCancelado) {
        this.fechaCancelado = fechaCancelado;
    }

    public float getInteresMoratorio() {
        return interesMoratorio;
    }

    public void setInteresMoratorio(float interesMoratorio) {
        this.interesMoratorio = interesMoratorio;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

}
