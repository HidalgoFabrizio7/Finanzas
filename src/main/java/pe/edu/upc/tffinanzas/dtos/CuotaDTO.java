package pe.edu.upc.tffinanzas.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.tffinanzas.entities.Factura;

import java.time.LocalDate;

public class CuotaDTO {
    private int idCuota;
    private double montoCancelado;
    private double interes;
    private LocalDate fechaCancelado;
    private double interesMoratorio;
    private double deudaRestante;
    private int plazoLimite;
    private String plazodegracia;

    public String getPlazodegracia() {
        return plazodegracia;
    }

    public void setPlazodegracia(String plazodegracia) {
        this.plazodegracia = plazodegracia;
    }

    private Factura factura;

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
}
