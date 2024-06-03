package pe.edu.upc.finanzasv3.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.finanzasv3.entities.Cancelado;
import pe.edu.upc.finanzasv3.repositories.ICanceladoRepository;
import pe.edu.upc.finanzasv3.serviceinterface.ICanceladoService;

@Service
public class CanceladoServiceImplement implements ICanceladoService {
    @Autowired
    private ICanceladoRepository cR;

    @Override
    public void insert(Cancelado cancelado) {cR.save(cancelado);}
}
