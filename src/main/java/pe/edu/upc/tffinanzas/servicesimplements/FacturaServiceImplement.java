package pe.edu.upc.tffinanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tffinanzas.entities.Cuota;
import pe.edu.upc.tffinanzas.entities.Factura;

import pe.edu.upc.tffinanzas.repositories.IFacturaRepository;
import pe.edu.upc.tffinanzas.servicesinterfaces.ICuotaService;
import pe.edu.upc.tffinanzas.servicesinterfaces.IFacturaService;

import java.util.List;
import java.util.Objects;

@Service
public class FacturaServiceImplement implements IFacturaService {
    @Autowired
    private IFacturaRepository fR;
    @Autowired
    private ICuotaService cS;

    @Override
    public void insert(Factura factura) {
        factura.setDeudaFinal(factura.calculoDeuda());
        fR.save(factura);
        for (int i = 0; i < factura.getCantPeriodo(); i++) {
            Cuota cuota = new Cuota();
            cuota.setFactura(factura);
            cuota.setFechaCancelado(factura.getFechaFactura());
            cuota.setMontoCancelado(factura.getDeudaFinal());
            cuota.setPlazoLimite(factura.getPlazoPago());
            if (Objects.equals(factura.getTipoTasa(), "Anualidad simple adelantada")||
                    Objects.equals(factura.getTipoTasa(), "Anualidad simple vencida")){
                int temp = 7*(i+1);
                cuota.setPlazoLimite(temp);
                cuota.setDeudaRestante(factura.getDeudaFinal());
            }
            cuota.setDeudaRestante(factura.getDeudaFinal());
            cS.insert(cuota);
        }

    }

    @Override
    public void delete(int id) {
        fR.deleteById(id);
    }

    @Override
    public List<Factura> ListFacturasByCliente(Long idFactura) {
        return fR.ListFacturasByCliente(idFactura);
    }

    @Override
    public List<Factura> ListFacturas() {
        return fR.ListFacturas();
    }

    @Override
    public Factura listId(int id) {
        return fR.findById(id).orElse(new Factura());
    }
}
