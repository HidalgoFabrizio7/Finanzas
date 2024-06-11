package pe.edu.upc.finanzasv3.dtos;

import jakarta.persistence.Column;
import pe.edu.upc.finanzasv3.entities.Users;

import java.time.LocalDate;

public class FacturaDTO {
    private int idFactura;
    private float montoPrestamo;
    //ESTADOS DE FACTURA: Pendiente, Pagado, Renovado
    private String estadoFactura;
    private String tipoTasa;
    private float tasa;
    private float tasaMoratoria;
    private int plazoPago;
    private LocalDate fechaFactura;
    private float periodoTasa;
    //este dato ira cambiando por la cantidad de cancelaciones
    private float deudaPendiente;
    private int periodoActual;
    private String responsableFactura;
    private double interesFactura;
    private Users user;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public float getMontoPrestamo() {
        return montoPrestamo;
    }

    public void setMontoPrestamo(float montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public String getTipoTasa() {
        return tipoTasa;
    }

    public void setTipoTasa(String tipoTasa) {
        this.tipoTasa = tipoTasa;
    }

    public float getTasa() {
        return tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    public float getTasaMoratoria() {
        return tasaMoratoria;
    }

    public void setTasaMoratoria(float tasaMoratoria) {
        this.tasaMoratoria = tasaMoratoria;
    }

    public int getPlazoPago() {
        return plazoPago;
    }

    public void setPlazoPago(int plazoPago) {
        this.plazoPago = plazoPago;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public float getPeriodoTasa() {
        return periodoTasa;
    }

    public void setPeriodoTasa(float periodoTasa) {
        this.periodoTasa = periodoTasa;
    }

    public float getDeudaPendiente() {
        return deudaPendiente;
    }

    public void setDeudaPendiente(float deudaPendiente) {
        this.deudaPendiente = deudaPendiente;
    }

    public int getPeriodoActual() {
        return periodoActual;
    }

    public void setPeriodoActual(int periodoActual) {
        this.periodoActual = periodoActual;
    }

    public String getResponsableFactura() {
        return responsableFactura;
    }

    public void setResponsableFactura(String responsableFactura) {
        this.responsableFactura = responsableFactura;
    }

    public double getInteresFactura() {
        return interesFactura;
    }

    public void setInteresFactura(double interesFactura) {
        this.interesFactura = interesFactura;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
