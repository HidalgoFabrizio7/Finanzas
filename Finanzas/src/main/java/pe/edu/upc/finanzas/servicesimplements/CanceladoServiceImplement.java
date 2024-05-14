package pe.edu.upc.finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.finanzas.dtos.CanceladoDTO;
import pe.edu.upc.finanzas.entities.Cancelado;
import pe.edu.upc.finanzas.repositories.ICanceladoRepository;
import pe.edu.upc.finanzas.servicesinterfaces.ICanceladoService;

import java.util.List;

@Service
public class CanceladoServiceImplement implements ICanceladoService {
    @Autowired
    private ICanceladoRepository canR;

    @Override
    public void Registrar(Cancelado cancelado) {
        canR.save(cancelado);
    }

    @Override
    public List<CanceladoDTO> CancelacionesPorFactura(Integer idFactura) {
        return canR.CancelacionesPorFactura(idFactura);
    }
}
