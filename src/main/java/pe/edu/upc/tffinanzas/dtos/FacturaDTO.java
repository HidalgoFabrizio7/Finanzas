package pe.edu.upc.tffinanzas.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.tffinanzas.entities.Users;

import java.time.LocalDate;

public class FacturaDTO {
    private int idFactura;
    private double montoPrestamo;
    private String estadoFactura;
    private String tipoTasa;
    private double tasa;
    private double tasaMoratoria;
    private int plazoPago;
    private int cantPeriodo;
    private LocalDate fechaFactura;
    private LocalDate fechaLimite;
    private int periodoTasa;
    private double deudaFinal;
    private double interesFactura;
    private String responsableFactura;
    private Users user;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public double getMontoPrestamo() {
        return montoPrestamo;
    }

    public void setMontoPrestamo(double montoPrestamo) {
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

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getTasaMoratoria() {
        return tasaMoratoria;
    }

    public void setTasaMoratoria(double tasaMoratoria) {
        this.tasaMoratoria = tasaMoratoria;
    }

    public int getPlazoPago() {
        return plazoPago;
    }

    public void setPlazoPago(int plazoPago) {
        this.plazoPago = plazoPago;
    }

    public int getCantPeriodo() {
        return cantPeriodo;
    }

    public void setCantPeriodo(int cantPeriodo) {
        this.cantPeriodo = cantPeriodo;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public int getPeriodoTasa() {
        return periodoTasa;
    }

    public void setPeriodoTasa(int periodoTasa) {
        this.periodoTasa = periodoTasa;
    }

    public double getDeudaFinal() {
        return deudaFinal;
    }

    public void setDeudaFinal(double deudaFinal) {
        this.deudaFinal = deudaFinal;
    }

    public double getInteresFactura() {
        return interesFactura;
    }

    public void setInteresFactura(double interesFactura) {
        this.interesFactura = interesFactura;
    }

    public String getResponsableFactura() {
        return responsableFactura;
    }

    public void setResponsableFactura(String responsableFactura) {
        this.responsableFactura = responsableFactura;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
