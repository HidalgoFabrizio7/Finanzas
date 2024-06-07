package pe.edu.upc.finanzasv3.dtos;

import jakarta.persistence.Column;

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

}
