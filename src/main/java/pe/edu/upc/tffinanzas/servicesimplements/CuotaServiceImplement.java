package pe.edu.upc.tffinanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tffinanzas.entities.Cuota;
import pe.edu.upc.tffinanzas.repositories.ICuotaRepository;
import pe.edu.upc.tffinanzas.servicesinterfaces.ICuotaService;

import java.util.List;

@Service
public class CuotaServiceImplement implements ICuotaService {
    @Autowired
    private ICuotaRepository cR;

    @Override
    public void insert(Cuota cuota) {
        cuota.calcularDeuda();
        cR.save(cuota);
    }

    @Override
    public List<Cuota> list() {
        return cR.findAll();
    }

    @Override
    public List<Cuota> listCanceladoByFactura(int idFactura) {
        return cR.listCuotaByFactura(idFactura);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public Cuota listId(int id) {
        return cR.findById(id).orElse(new Cuota());
    }
}
