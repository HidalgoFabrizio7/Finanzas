package pe.edu.upc.finanzasv3.dtos;

import java.time.LocalDate;

public class ListaFacturaAminDTO {
    int row_number;
    String Cliente;
    LocalDate FechaPrestamo;
    float Monto;
    String TasaInteres;
    float PorcentajeTasa;
    int Periodo;
    String Estado;
    String Cajero;

    public int getRow_number() {
        return row_number;
    }

    public void setRow_number(int row_number) {
        this.row_number = row_number;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public LocalDate getFechaPrestamo() {
        return FechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        FechaPrestamo = fechaPrestamo;
    }

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float monto) {
        Monto = monto;
    }

    public String getTasaInteres() {
        return TasaInteres;
    }

    public void setTasaInteres(String tasaInteres) {
        TasaInteres = tasaInteres;
    }

    public float getPorcentajeTasa() {
        return PorcentajeTasa;
    }

    public void setPorcentajeTasa(float porcentajeTasa) {
        PorcentajeTasa = porcentajeTasa;
    }

    public int getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(int periodo) {
        Periodo = periodo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getCajero() {
        return Cajero;
    }

    public void setCajero(String cajero) {
        Cajero = cajero;
    }
}
