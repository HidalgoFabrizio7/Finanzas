package pe.edu.upc.finanzasv3.serviceinterface;

import pe.edu.upc.finanzasv3.entities.Factura;
import pe.edu.upc.finanzasv3.entities.Users;

import java.time.LocalDate;
import java.util.List;

public interface IFacturaService {
    public List<String[]> listarFacturaPersonalizadaAdmin();
    public List<String[]> FiltroPorFechalistarFacturaPersonalizadaAdmin(LocalDate fecha);
    public List<String[]> FiltroPorEstadolistarFacturaPersonalizadaAdmin(String estado);

    public List<String[]> listarFacturaPersonalizadaCliente(Long idUsuario);
    public List<String[]> FiltroPorFechalistarFacturaPersonalizadaCliente(Long idUsuario, LocalDate fecha);
    public List<String[]> FiltroPorEstadolistarFacturaPersonalizadaCliente(Long idUsuario, String estado);

    public void insert(Factura factura);
    public void delete(int id);
    public List<Factura> ListFacturasByCliente(Long id);
    public List<Factura> ListFacturas();
    public Factura listId(int id);
}
