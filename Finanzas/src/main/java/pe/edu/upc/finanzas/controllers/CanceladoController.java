package pe.edu.upc.finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.finanzas.dtos.CanceladoDTO;
import pe.edu.upc.finanzas.entities.Cancelado;
import pe.edu.upc.finanzas.servicesinterfaces.ICanceladoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Cancelaciones")
public class CanceladoController {
    @Autowired
    private ICanceladoService canS;
    @PostMapping
    public void insertar(@RequestBody CanceladoDTO canceladoDTO){
        ModelMapper m = new ModelMapper();
        Cancelado c = m.map(canceladoDTO, Cancelado.class);
        canS.Registrar(c);
    }

    @GetMapping
    public List<CanceladoDTO> ListarCancelacionesPorFactura(@RequestParam Integer idFactura){
        return canS.CancelacionesPorFactura(idFactura).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, CanceladoDTO.class);
        }).collect(Collectors.toList());
    }
}
