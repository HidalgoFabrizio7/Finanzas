package pe.edu.upc.finanzasv3.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

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

    //FUNCIONES
    public int calcularDiasTranscurridos() {
        LocalDate fechaFactura = factura.getFechaFactura();
        if (fechaFactura == null || fechaCancelado == null) {
            return 0; //  caso en que las fechas son nulas
        }
        Period periodo = Period.between(fechaFactura, fechaCancelado);
        return periodo.getDays();
    }

    private void calcularDeuda(){
        double capital = factura.getMontoPrestamo();
        double tasa = factura.getTasa()/100;
        double tasaM = factura.getTasaMoratoria()/100;
        double tiempo = calcularDiasTranscurridos();
        float deuda = factura.getDeudaPendiente();
        if ((factura.getPlazoPago()-calcularDiasTranscurridos())<0) {
            deuda = deuda + (float) (calculoDeMora(capital, tasaM, tiempo));
        }else {
            if (Objects.equals(factura.getTipoTasa(), "Tasa efectiva del periodo")){
                deuda = (float) calcularTasaEfectivaDelPeriodo(capital, tasa, tiempo);
            }
        }
        if (Objects.equals(factura.getTipoTasa(), "Anualidad simple adelantada")||
                Objects.equals(factura.getTipoTasa(), "Anualidad simple vencida")){
            factura.setPeriodoActual(factura.getPeriodoActual()+1);
        }
        factura.setDeudaPendiente(deuda);
        deuda = deuda - montoCancelado;
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
        double r;
        double a = (1+(tasa));
        double b = tiempo/factura.getPeriodoTasa();
        r = capital*(Math.pow(a, b)-1);
        return r;
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

}
