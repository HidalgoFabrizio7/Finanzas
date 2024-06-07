package pe.edu.upc.finanzasv3.serviceinterface;

import pe.edu.upc.finanzasv3.entities.Cancelado;

import java.util.List;

public interface ICanceladoService {
    public void insert(Cancelado cancelado);
    public List<Cancelado> list();
    public List<Cancelado> listCanceladoByFactura(int id);
    public void delete(int id);
    public Cancelado listId(int id);

}
