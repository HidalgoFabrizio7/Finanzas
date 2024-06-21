package pe.edu.upc.tffinanzas.servicesinterfaces;

import pe.edu.upc.tffinanzas.entities.Factura;

import java.util.List;

public interface IFacturaService {
    public void insert(Factura factura);
    public void delete(int id);
    public List<Factura> ListFacturasByCliente(Long id);
    public List<Factura> ListFacturas();
    public Factura listId(int id);
}
