package pe.edu.upc.tffinanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tffinanzas.dtos.FacturaDTO;
import pe.edu.upc.tffinanzas.entities.Factura;
import pe.edu.upc.tffinanzas.servicesinterfaces.IFacturaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Facturas")
public class FacturaController {
    @Autowired
    private IFacturaService fS;

    @PostMapping
    public void registrar(@RequestBody FacturaDTO dto) {
        ModelMapper m = new ModelMapper();
        Factura fp = m.map(dto, Factura.class);
        fS.insert(fp);
    }
    @PutMapping
    public void editar(@RequestBody FacturaDTO dto){
        ModelMapper m=new ModelMapper();
        Factura f=m.map(dto, Factura.class);
        fS.insert(f);
    }
    @GetMapping
    public List<FacturaDTO> ListFacturas(){
        return fS.ListFacturas().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, FacturaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/listarporcliente/{id}")
    public List<FacturaDTO> listarFacturasByCliente(@PathVariable("id") Long id){
        return fS.ListFacturasByCliente(id).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, FacturaDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        fS.delete(id);
    }

    @GetMapping("/{id}")
    public FacturaDTO listarId(@PathVariable("id") int id){
        ModelMapper m =new ModelMapper();
        FacturaDTO dto=m.map(fS.listId(id), FacturaDTO.class);
        return dto;
    }

}
