package pe.edu.upc.finanzasv3.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.finanzasv3.entities.Factura;

import java.time.LocalDate;

public class CanceladoDTO {
    private int idCancelado;
    private float montoCancelado;
    private float interes;
    private LocalDate fechaCancelado;
    private float interesMoratorio;
    private float deudaRestante;
    private int plazoLimite;

    private Factura factura;

    public int getPlazoLimite() {
        return plazoLimite;
    }

    public void setPlazoLimite(int plazoLimite) {
        this.plazoLimite = plazoLimite;
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

    public float getDeudaRestante() {
        return deudaRestante;
    }

    public void setDeudaRestante(float deudaRestante) {
        this.deudaRestante = deudaRestante;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
