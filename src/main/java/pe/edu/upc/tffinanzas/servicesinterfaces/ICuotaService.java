package pe.edu.upc.tffinanzas.servicesinterfaces;

import pe.edu.upc.tffinanzas.entities.Cuota;

import java.util.List;

public interface ICuotaService {
    public void insert(Cuota cuota);
    public List<Cuota> list();
    public List<Cuota> listCanceladoByFactura(int id);
    public void delete(int id);
    public Cuota listId(int id);
}
