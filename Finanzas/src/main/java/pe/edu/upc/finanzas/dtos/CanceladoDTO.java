package pe.edu.upc.finanzas.dtos;

import jakarta.persistence.Column;
import pe.edu.upc.finanzas.entities.Factura;

import java.time.LocalDate;

public class CanceladoDTO {
    private int idCancelado;
    private float montoCancelado;
    private float deudaCancelado;
    private float interesCancelado;
    private LocalDate fechaCancelado;
    private Factura factura;

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

    public float getDeudaCancelado() {
        return deudaCancelado;
    }

    public void setDeudaCancelado(float deudaCancelado) {
        this.deudaCancelado = deudaCancelado;
    }

    public float getInteresCancelado() {
        return interesCancelado;
    }

    public void setInteresCancelado(float interesCancelado) {
        this.interesCancelado = interesCancelado;
    }

    public LocalDate getFechaCancelado() {
        return fechaCancelado;
    }

    public void setFechaCancelado(LocalDate fechaCancelado) {
        this.fechaCancelado = fechaCancelado;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
