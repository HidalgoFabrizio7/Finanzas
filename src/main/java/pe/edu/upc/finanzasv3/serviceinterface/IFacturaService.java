package pe.edu.upc.finanzasv3.serviceinterface;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.finanzasv3.dtos.ListaFacturaAminDTO;
import pe.edu.upc.finanzasv3.entities.Cancelado;
import pe.edu.upc.finanzasv3.entities.Factura;

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
}
