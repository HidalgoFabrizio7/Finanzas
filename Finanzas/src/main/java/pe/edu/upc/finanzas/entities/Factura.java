package pe.edu.upc.finanzas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;
    @Column(name = "montoPrestamo", nullable = false)
    private float montoPrestamo;
    @Column(name = "estadoFactura", nullable = false, length = 45)
    private String estadoFactura;
    @Column(name = "tipoOperacion", nullable = false, length = 45)
    private String tipoOperacion;
    @Column(name = "tipoTasa", nullable = false, length = 45)
    private String tipoTasa;
    @Column(name = "tasa", nullable = false)
    private float tasa;
    @Column(name = "tasaMoratoria", nullable = false)
    private float tasaMoratoria;
    @Column(name = "plazoPago", nullable = false)
    private int plazoPago;
    @Column(name = "fechaFactura", nullable = false)
    private LocalDate fechaFactura;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Factura() {
    }

    public Factura(int idFactura, float montoPrestamo, String estadoFactura, String tipoOperacion, String tipoTasa, float tasa, float tasaMoratoria, int plazoPago, LocalDate fechaFactura, Users user) {
        this.idFactura = idFactura;
        this.montoPrestamo = montoPrestamo;
        this.estadoFactura = estadoFactura;
        this.tipoOperacion = tipoOperacion;
        this.tipoTasa = tipoTasa;
        this.tasa = tasa;
        this.tasaMoratoria = tasaMoratoria;
        this.plazoPago = plazoPago;
        this.fechaFactura = fechaFactura;
        this.user = user;
    }

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

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
