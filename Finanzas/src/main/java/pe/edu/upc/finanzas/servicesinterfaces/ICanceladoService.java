package pe.edu.upc.finanzas.servicesinterfaces;

import pe.edu.upc.finanzas.dtos.CanceladoDTO;
import pe.edu.upc.finanzas.entities.Cancelado;

import java.util.List;

public interface ICanceladoService {
    public void Registrar(Cancelado cancelado);
    public List<CanceladoDTO> CancelacionesPorFactura(Integer idFactura);
}
