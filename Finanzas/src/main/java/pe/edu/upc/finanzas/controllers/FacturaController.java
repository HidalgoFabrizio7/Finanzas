package pe.edu.upc.finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.finanzas.dtos.FacturaDTO;
import pe.edu.upc.finanzas.dtos.UsuarioClienteDTO;
import pe.edu.upc.finanzas.entities.Factura;
import pe.edu.upc.finanzas.servicesinterfaces.IFacturaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Faturas")
public class FacturaController {
    @Autowired
    private IFacturaService facS;

    @PostMapping
    public void insertar(@RequestBody FacturaDTO facturaDTO){
        ModelMapper m = new ModelMapper();
        Factura f = m.map(facturaDTO, Factura.class);
        facS.Registrar(f);
    }

    @GetMapping
    public List<FacturaDTO> ListarFacturasPorUsuario(@RequestParam Long idUsuario){
        return facS.FacturasPorUsuario(idUsuario).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, FacturaDTO.class);
        }).collect(Collectors.toList());
    }

}
