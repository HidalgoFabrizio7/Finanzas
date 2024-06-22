package pe.edu.upc.tffinanzas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "Cuotas")
public class Cuota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCuota;
    @Column(name = "montoCancelado", nullable = true  )
    private double montoCancelado;
    @Column(name = "interes", nullable = true  )
    private double interes;
    @Column(name = "fechaCancelado", nullable = true  )
    private LocalDate fechaCancelado;
    @Column(name = "interesMoratorio", nullable = true  )
    private double interesMoratorio;
    @Column(name = "deudaRestante", nullable = true  )
    private double deudaRestante;
    @Column (name = "plazoLimite", nullable = true  )
    private int plazoLimite;
    @Column (name = "plazodegracia", nullable = true  )
    private String plazodegracia;
    @ManyToOne
    @JoinColumn(name = "idFactura")
    private Factura factura;

    public Cuota() {
    }

    public Cuota(int idCuota, double montoCancelado, double interes, LocalDate fechaCancelado, double interesMoratorio, double deudaRestante, int plazoLimite, String plazodegracia, Factura factura) {
        this.idCuota = idCuota;
        this.montoCancelado = montoCancelado;
        this.interes = interes;
        this.fechaCancelado = fechaCancelado;
        this.interesMoratorio = interesMoratorio;
        this.deudaRestante = deudaRestante;
        this.plazoLimite = plazoLimite;
        this.plazodegracia = plazodegracia;
        this.factura = factura;
    }

    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public double getMontoCancelado() {
        return montoCancelado;
    }

    public void setMontoCancelado(double montoCancelado) {
        this.montoCancelado = montoCancelado;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public LocalDate getFechaCancelado() {
        return fechaCancelado;
    }

    public void setFechaCancelado(LocalDate fechaCancelado) {
        this.fechaCancelado = fechaCancelado;
    }

    public double getInteresMoratorio() {
        return interesMoratorio;
    }

    public void setInteresMoratorio(double interesMoratorio) {
        this.interesMoratorio = interesMoratorio;
    }

    public double getDeudaRestante() {
        return deudaRestante;
    }

    public void setDeudaRestante(double deudaRestante) {
        this.deudaRestante = deudaRestante;
    }

    public int getPlazoLimite() {
        return plazoLimite;
    }

    public void setPlazoLimite(int plazoLimite) {
        this.plazoLimite = plazoLimite;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getPlazodegracia() {
        return plazodegracia;
    }

    public void setPlazodegracia(String plazodegracia) {
        this.plazodegracia = plazodegracia;
    }

    //Calculos
    public int calcularDiasTranscurridos( ) {
        int periodoo;
        LocalDate fechaFactura = factura.getFechaFactura();
        Period periodo = Period.between(fechaFactura, fechaCancelado);
        periodoo = fechaCancelado.getDayOfMonth() + ((periodo.getMonths()*30)- fechaFactura.getDayOfMonth());
        return periodoo;
    }

    public void calcularDeuda( ){
        double capital = factura.getMontoPrestamo();
        double tasa = factura.getTasa()/100;
        double tasaM = factura.getTasaMoratoria()/100;
        double tiempo = calcularDiasTranscurridos();
        double deuda = factura.getDeudaFinal();
        double diferencia = (factura.getPlazoPago()-tiempo);

        if (factura.getFechaFactura()!=fechaCancelado){
            factura.setEstadoFactura("Cancelado");
        }

        switch (factura.getTipoTasa() ) {
            case "Tasa efectiva del periodo":
                if (factura.getFechaFactura()!=fechaCancelado ){
                    deuda = calcularTasaEfectivaDelPeriodo(capital,tasa,tiempo);
                }
                interes = (deuda-capital);
                break;
            case "Tasa de interes simple":
                interes = factura.getInteresFactura();
                break;

            case "Anualidad simple adelantada", "Anualidad simple vencida":
                switch (getPlazodegracia()){
                    case "Plazo total":
                        montoCancelado = 0;
                        break;
                    case "NA":
                        interes = factura.getInteresFactura();
                        diferencia = (plazoLimite-tiempo);
                        break;
                }
                break;
        }
        if (diferencia<0) {
            interesMoratorio = calculoDeMora(capital, tasaM, tiempo);
            deuda = deuda + (calculoDeMora(capital, tasaM, tiempo));
            factura.setEstadoFactura("Cancelacion Tardia");
        }

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
        double ra =0;
        double a = 1+(tasa);
        double b = tiempo/factura.getPeriodoTasa();
        ra= capital*Math.pow(a,b);
        return ra;
    }
}
