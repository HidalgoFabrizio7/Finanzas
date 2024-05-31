package pe.edu.upc.finanzasv3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.finanzasv3.dtos.ListaFacturaAminDTO;
import pe.edu.upc.finanzasv3.serviceinterface.IFacturaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Facturas")
public class FacturaController {
    @Autowired
    private IFacturaService facturaS;

    //LISTAR FACTURA CON VISTA PARA ADMIN
    @GetMapping("/ListarFacturasAdmin")
    public List<ListaFacturaAminDTO> ListFacturasVistaAdmin(){
        List<String[]> filaLista = facturaS.listarFacturaPersonalizadaAdmin();
        List<ListaFacturaAminDTO> dtoLista = new ArrayList<>();
        for (String[] columna: filaLista){
            ListaFacturaAminDTO dto = new ListaFacturaAminDTO();
            dto.setRow_number(Integer.parseInt(columna[0]));
            dto.setCliente(columna[1]);
            dto.setFechaPrestamo(LocalDate.parse(columna[2]));
            dto.setMonto(Float.parseFloat(columna[3]));
            dto.setTasaInteres(columna[4]);
            dto.setPorcentajeTasa(Float.parseFloat(columna[5]));
            dto.setPeriodo(Integer.parseInt(columna[6]));
            dto.setEstado(columna[7]);
            dto.setCajero(columna[8]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/FiltroFechaAdmin")
    public List<ListaFacturaAminDTO> FiltroFechaListFacturasVistaAdmin(@RequestParam LocalDate fecha){
        List<String[]> filaLista = facturaS.FiltroPorFechalistarFacturaPersonalizadaAdmin(fecha);
        List<ListaFacturaAminDTO> dtoLista = new ArrayList<>();
        for (String[] columna: filaLista){
            ListaFacturaAminDTO dto = new ListaFacturaAminDTO();
            dto.setRow_number(Integer.parseInt(columna[0]));
            dto.setCliente(columna[1]);
            dto.setFechaPrestamo(LocalDate.parse(columna[2]));
            dto.setMonto(Float.parseFloat(columna[3]));
            dto.setTasaInteres(columna[4]);
            dto.setPorcentajeTasa(Float.parseFloat(columna[5]));
            dto.setPeriodo(Integer.parseInt(columna[6]));
            dto.setEstado(columna[7]);
            dto.setCajero(columna[8]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/FiltroEstadoAdmin")
    public List<ListaFacturaAminDTO> FiltroEstadoListFacturasVistaAdmin(@RequestParam String estado){
        List<String[]> filaLista = facturaS.FiltroPorEstadolistarFacturaPersonalizadaAdmin(estado);
        List<ListaFacturaAminDTO> dtoLista = new ArrayList<>();
        for (String[] columna: filaLista){
            ListaFacturaAminDTO dto = new ListaFacturaAminDTO();
            dto.setRow_number(Integer.parseInt(columna[0]));
            dto.setCliente(columna[1]);
            dto.setFechaPrestamo(LocalDate.parse(columna[2]));
            dto.setMonto(Float.parseFloat(columna[3]));
            dto.setTasaInteres(columna[4]);
            dto.setPorcentajeTasa(Float.parseFloat(columna[5]));
            dto.setPeriodo(Integer.parseInt(columna[6]));
            dto.setEstado(columna[7]);
            dto.setCajero(columna[8]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    //LISTAR FACTURA CON VISTA PARA CLIENTE
    @GetMapping("/ListarFacturasCliente")
    public List<ListaFacturaAminDTO> ListFacturasVistaCliente(@RequestParam Long idUsuario){
        List<String[]> filaLista = facturaS.listarFacturaPersonalizadaCliente(idUsuario);
        List<ListaFacturaAminDTO> dtoLista = new ArrayList<>();
        for (String[] columna: filaLista){
            ListaFacturaAminDTO dto = new ListaFacturaAminDTO();
            dto.setRow_number(Integer.parseInt(columna[0]));
            dto.setCliente(columna[1]);
            dto.setFechaPrestamo(LocalDate.parse(columna[2]));
            dto.setMonto(Float.parseFloat(columna[3]));
            dto.setTasaInteres(columna[4]);
            dto.setPorcentajeTasa(Float.parseFloat(columna[5]));
            dto.setPeriodo(Integer.parseInt(columna[6]));
            dto.setEstado(columna[7]);
            dto.setCajero(columna[8]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/FiltroFechaCliente")
    public List<ListaFacturaAminDTO> FiltroFechaListFacturasVistaCliente(@RequestParam Long idUsuario, @RequestParam LocalDate fecha){
        List<String[]> filaLista = facturaS.FiltroPorFechalistarFacturaPersonalizadaCliente(idUsuario, fecha);
        List<ListaFacturaAminDTO> dtoLista = new ArrayList<>();
        for (String[] columna: filaLista){
            ListaFacturaAminDTO dto = new ListaFacturaAminDTO();
            dto.setRow_number(Integer.parseInt(columna[0]));
            dto.setCliente(columna[1]);
            dto.setFechaPrestamo(LocalDate.parse(columna[2]));
            dto.setMonto(Float.parseFloat(columna[3]));
            dto.setTasaInteres(columna[4]);
            dto.setPorcentajeTasa(Float.parseFloat(columna[5]));
            dto.setPeriodo(Integer.parseInt(columna[6]));
            dto.setEstado(columna[7]);
            dto.setCajero(columna[8]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/FiltroEstadoCliente")
    public List<ListaFacturaAminDTO> FiltroEstadoListFacturasVistaCliente(@RequestParam Long idUsuario, @RequestParam String estado){
        List<String[]> filaLista = facturaS.FiltroPorEstadolistarFacturaPersonalizadaCliente(idUsuario, estado);
        List<ListaFacturaAminDTO> dtoLista = new ArrayList<>();
        for (String[] columna: filaLista){
            ListaFacturaAminDTO dto = new ListaFacturaAminDTO();
            dto.setRow_number(Integer.parseInt(columna[0]));
            dto.setCliente(columna[1]);
            dto.setFechaPrestamo(LocalDate.parse(columna[2]));
            dto.setMonto(Float.parseFloat(columna[3]));
            dto.setTasaInteres(columna[4]);
            dto.setPorcentajeTasa(Float.parseFloat(columna[5]));
            dto.setPeriodo(Integer.parseInt(columna[6]));
            dto.setEstado(columna[7]);
            dto.setCajero(columna[8]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}