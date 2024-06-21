package pe.edu.upc.tffinanzas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;

    @Column(name = "montoPrestamo", nullable = true)
    private double montoPrestamo;
    @Column(name = "estadoFactura", nullable = true, length = 45)
    private String estadoFactura;
    @Column(name = "tipoTasa", nullable = true, length = 45)
    private String tipoTasa;
    @Column(name = "tasa", nullable = true)
    private double tasa;
    @Column(name = "tasaMoratoria", nullable = true)
    private double tasaMoratoria;
    @Column(name = "plazoPago", nullable = true)
    private int plazoPago;
    @Column(name = "cantPeriodo", nullable = true)
    private int cantPeriodo;
    @Column(name = "fechaFactura", nullable = true)
    private LocalDate fechaFactura;
    @Column(name = "fechaLimite", nullable = true)
    private LocalDate fechaLimite;
    @Column(name = "periodoTasa", nullable = true  )
    private int periodoTasa;
    @Column(name = "deudaFinal", nullable = true  )
    private double deudaFinal;
    @Column(name = "interesFactura", nullable = true)
    private double interesFactura;
    @Column(name = "responsableFactura", nullable = true, length = 45)
    private String responsableFactura;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Factura() {
    }

    public Factura(int idFactura, double montoPrestamo, String estadoFactura, String tipoTasa, double tasa, double tasaMoratoria, int plazoPago, int cantPeriodo, LocalDate fechaFactura, LocalDate fechaLimite, int periodoTasa, double deudaFinal, double interesFactura, String responsableFactura, Users user) {
        this.idFactura = idFactura;
        this.montoPrestamo = montoPrestamo;
        this.estadoFactura = estadoFactura;
        this.tipoTasa = tipoTasa;
        this.tasa = tasa;
        this.tasaMoratoria = tasaMoratoria;
        this.plazoPago = plazoPago;
        this.cantPeriodo = cantPeriodo;
        this.fechaFactura = fechaFactura;
        this.fechaLimite = fechaLimite;
        this.periodoTasa = periodoTasa;
        this.deudaFinal = deudaFinal;
        this.interesFactura = interesFactura;
        this.responsableFactura = responsableFactura;
        this.user = user;
    }

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

    //Calculos
    public double calculoDeuda(){
        double deuda = 0;
        switch (tipoTasa) {
            case "Tasa de interes simple":
                deuda = calcularTasaSimple();
                interesFactura = deuda-montoPrestamo;
                setCantPeriodo(1);
                break;
            case "Tasa efectiva del periodo":
                deuda = calcularTasaEfectivaDelPerido();
                interesFactura = deuda-montoPrestamo;
                setCantPeriodo(1);
                break;
            case "Anualidad simple adelantada", "Anualidad simple vencida":
                deuda = calcularAnualidad();
                interesFactura = deuda - (montoPrestamo/cantPeriodo);
                break;
        }
        estadoFactura = "Pendiente";
        return deuda;
    }

    private double calcularTasaSimple(){
        double r;
        double t = plazoPago/periodoTasa;
        r = montoPrestamo*(1+((tasa/100)*t));
        return r;
    }

    private double calcularTasaEfectivaDelPerido(){
        double r;
        double a=1+(tasa/100);
        double b=plazoPago/periodoTasa;
        r = montoPrestamo*Math.pow(a,b);
        return r;
    }

    private double calcularAnualidad(){
        double ra =0;
        double tas = tasa/100;
        int tipo = 0;
        if (Objects.equals(tipoTasa, "Anualidad simple adelantada")){
            tipo = 1;
        }

        if (Objects.equals(tipoTasa, "Anualidad simple vencida")){
            tipo = 0;
        }

        double  NperiodoRenta = Math.floor((double) plazoPago /7);

        setCantPeriodo((int) NperiodoRenta);

        ra = montoPrestamo*( (tas * (Math.pow((1 + tas),NperiodoRenta-tipo)) /(((Math.pow((1 + tas),NperiodoRenta))-1))));

        return ra;
    }

}
