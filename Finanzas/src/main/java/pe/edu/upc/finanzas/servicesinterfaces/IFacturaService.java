package pe.edu.upc.finanzas.servicesinterfaces;

import pe.edu.upc.finanzas.dtos.FacturaDTO;
import pe.edu.upc.finanzas.entities.Factura;

import java.util.List;

public interface IFacturaService {
    public void Registrar(Factura factura);
    public List<FacturaDTO> FacturasPorUsuario(Long idUsuario);

}
