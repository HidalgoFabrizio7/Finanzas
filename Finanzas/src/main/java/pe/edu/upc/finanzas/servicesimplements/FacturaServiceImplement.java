package pe.edu.upc.finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.finanzas.dtos.FacturaDTO;
import pe.edu.upc.finanzas.entities.Factura;
import pe.edu.upc.finanzas.repositories.IFacturaRepository;
import pe.edu.upc.finanzas.servicesinterfaces.IFacturaService;

import java.util.List;
@Service
public class FacturaServiceImplement implements IFacturaService {
    @Autowired
    private IFacturaRepository facR;

    @Override
    public void Registrar(Factura factura) {
        facR.save(factura);
    }

    @Override
    public List<FacturaDTO> FacturasPorUsuario(Long idUsuario) {
        return facR.FacturasPorUsuarioSinCancelar(idUsuario);
    }
}
