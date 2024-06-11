package pe.edu.upc.finanzasv3.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;

    @Column(name = "montoPrestamo", nullable = true)
    private float montoPrestamo;
    //ESTADOS DE FACTURA: Pendiente, Pagado, Renovado
    @Column(name = "estadoFactura", nullable = true, length = 45)
    private String estadoFactura;
    @Column(name = "tipoTasa", nullable = true, length = 45)
    private String tipoTasa;
    @Column(name = "tasa", nullable = true)
    private float tasa;
    @Column(name = "tasaMoratoria", nullable = true)
    private float tasaMoratoria;
    @Column(name = "plazoPago", nullable = true)
    private int plazoPago;
    @Column(name = "fechaFactura", nullable = true)
    private LocalDate fechaFactura;
    @Column(name = "periodoTasa", nullable = true  )
    private float periodoTasa;
    //este dato ira cambiando por la cantidad de cancelaciones
    @Column(name = "deudaPendiente", nullable = true  )
    private float deudaPendiente;
    @Column(name = "periodoActual", nullable = true  )
    private int periodoActual;
    @Column(name = "responsableFactura", nullable = true, length = 45)
    private String responsableFactura;
    @Column(name = "interesFactura", nullable = true)
    private double interesFactura;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Factura() {
    }

    public Factura(int idFactura, float montoPrestamo, String estadoFactura, String tipoTasa, float tasa, float tasaMoratoria, int plazoPago, LocalDate fechaFactura, float periodoTasa, float deudaPendiente, String responsableFactura, int periodoActual, double interesFactura, Users user) {
        this.idFactura = idFactura;
        this.montoPrestamo = montoPrestamo;
        this.estadoFactura = estadoFactura;
        this.tipoTasa = tipoTasa;
        this.tasa = tasa;
        this.tasaMoratoria = tasaMoratoria;
        this.plazoPago = plazoPago;
        this.fechaFactura = fechaFactura;
        this.periodoTasa = periodoTasa;
        this.deudaPendiente = deudaPendiente;
        this.responsableFactura = responsableFactura;
        this.periodoActual = periodoActual;
        this.interesFactura = interesFactura;
        this.user = user;
    }

    //calculos
    public float deudaPendiente(){
        float deuda = 0;
        switch (tipoTasa) {
            case "Tasa de interes simple":
                deuda = calcularTasaSimple();
                interesFactura = deuda-montoPrestamo;
                break;
            case "Tasa efectiva del periodo":
                deuda = (float) calcularTasaEfectivaDelPerido();
                interesFactura = deuda-montoPrestamo;
                break;
            case "Anualidad simple adelantada", "Anualidad simple vencida":
                deuda = (float) calcularAnualidad();
                interesFactura = (periodoActual*deudaPendiente)-montoPrestamo;
                break;
        }
        estadoFactura = "Pendiente";
        return deuda;
    }

    private float calcularTasaSimple(){
        float r;
        float t = plazoPago/periodoTasa;
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
        periodoActual = (int) NperiodoRenta;

        ra = montoPrestamo*( (tas * (Math.pow((1 + tas),NperiodoRenta-tipo)) /(((Math.pow((1 + tas),NperiodoRenta))-1))));

        return ra;
    }


    //getters and setters
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

    public int getPeriodoActual() {
        return periodoActual;
    }

    public void setPeriodoActual(int periodoActual) {
        this.periodoActual = periodoActual;
    }

    public double getInteresFactura() {
        return interesFactura;
    }

    public void setInteresFactura(double interesFactura) {
        this.interesFactura = interesFactura;
    }
}
