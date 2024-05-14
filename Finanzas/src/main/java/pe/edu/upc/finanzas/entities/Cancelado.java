package pe.edu.upc.finanzas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Cancelado")
public class Cancelado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCancelado;
    @Column(name = "montoCancelado", nullable = false  )
    private float montoCancelado;
    @Column(name = "deudaCancelado", nullable = false  )
    private float deudaCancelado;
    @Column(name = "interesCancelado", nullable = false  )
    private float interesCancelado;
    @Column(name = "fechaCancelado", nullable = false  )
    private LocalDate fechaCancelado;
    @ManyToOne
    @JoinColumn(name = "idFactura")
    private Factura factura;

    public Cancelado() {
    }

    public Cancelado(int idCancelado, float montoCancelado, float deudaCancelado, float interesCancelado, LocalDate fechaCancelado, Factura factura) {
        this.idCancelado = idCancelado;
        this.montoCancelado = montoCancelado;
        this.deudaCancelado = deudaCancelado;
        this.interesCancelado = interesCancelado;
        this.fechaCancelado = fechaCancelado;
        this.factura = factura;
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
