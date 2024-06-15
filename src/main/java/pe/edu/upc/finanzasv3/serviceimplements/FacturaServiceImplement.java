package pe.edu.upc.finanzasv3.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.finanzasv3.entities.Cancelado;
import pe.edu.upc.finanzasv3.entities.Factura;
import pe.edu.upc.finanzasv3.entities.Users;
import pe.edu.upc.finanzasv3.repositories.ICanceladoRepository;
import pe.edu.upc.finanzasv3.repositories.IFacturaRepository;
import pe.edu.upc.finanzasv3.serviceinterface.ICanceladoService;
import pe.edu.upc.finanzasv3.serviceinterface.IFacturaService;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

@Service
public class FacturaServiceImplement implements IFacturaService {
    @Autowired
    private IFacturaRepository facturaR;
    @Autowired
    private ICanceladoRepository canceladoR;
    @Autowired
    private ICanceladoService cR;


    @Override
    public List<String[]> listarFacturaPersonalizadaAdmin() {
        return facturaR.listarFacturaPersonalizadaAdmin();
    }

    @Override
    public List<String[]> FiltroPorFechalistarFacturaPersonalizadaAdmin(LocalDate fecha) {
        return facturaR.FiltroPorFechalistarFacturaPersonalizadaAdmin(fecha);
    }

    @Override
    public List<String[]> FiltroPorEstadolistarFacturaPersonalizadaAdmin(String estado) {
        return facturaR.FiltroPorEstadolistarFacturaPersonalizadaAdmin(estado);
    }

    @Override
    public List<String[]> listarFacturaPersonalizadaCliente(Long idUsuario) {
        return facturaR.listarFacturaPersonalizadaCliente(idUsuario);
    }

    @Override
    public List<String[]> FiltroPorFechalistarFacturaPersonalizadaCliente(Long idUsuario, LocalDate fecha) {
        return facturaR.FiltroPorFechalistarFacturaPersonalizadaCliente(idUsuario, fecha);
    }

    @Override
    public List<String[]> FiltroPorEstadolistarFacturaPersonalizadaCliente(Long idUsuario, String estado) {
        return facturaR.FiltroPorEstadolistarFacturaPersonalizadaCliente(idUsuario, estado);
    }

    //CRUD

    @Override
    public void insert(Factura factura) {
        factura.setDeudaPendiente(factura.deudaPendiente());
        facturaR.save(factura);


        for (int i = 0; i < factura.getPeriodoActual(); i++) {
            Cancelado cancelado = new Cancelado();
            cancelado.setFactura(factura);
            cancelado.setFechaCancelado(factura.getFechaFactura());
            cancelado.setMontoCancelado(factura.getDeudaPendiente());
            cancelado.setPlazoLimite(factura.getPlazoPago());
            if (Objects.equals(factura.getTipoTasa(), "Anualidad simple adelantada")||
                    Objects.equals(factura.getTipoTasa(), "Anualidad simple vencida")){
                int temp = 7*(i+1);
                cancelado.setPlazoLimite(temp);
                cancelado.setDeudaRestante(factura.getDeudaPendiente());
            }
            cancelado.setDeudaRestante(factura.getDeudaPendiente());
            cR.insert(cancelado);
        }
    }

    @Override
    public void delete(int id) {
        facturaR.deleteById(id);
    }

    @Override
    public List<Factura> ListFacturasByCliente(Long id) {
        return facturaR.ListFacturasByCliente(id);
    }

    @Override
    public List<Factura> ListFacturas() {
        return facturaR.ListFacturas();
    }

    @Override
    public Factura listId(int id) {
        return facturaR.findById(id).orElse(new Factura());
    }


}
