package pe.edu.upc.finanzasv3.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.finanzasv3.entities.Cancelado;
import pe.edu.upc.finanzasv3.repositories.ICanceladoRepository;
import pe.edu.upc.finanzasv3.serviceinterface.ICanceladoService;

import java.util.List;

@Service
public class CanceladoServiceImplement implements ICanceladoService {
    @Autowired
    private ICanceladoRepository cR;

    @Override
    public void insert(Cancelado cancelado) {cR.save(cancelado);}

    @Override
    public List<Cancelado> list() {
        return cR.findAll();
    }

    @Override
    public List<Cancelado> listCanceladoByFactura(int id) {
        return cR.listCanceladoByFactura(id);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public Cancelado listId(int id) {
        return cR.findById(id).orElse(new Cancelado());
    }
}
