package pe.edu.upc.tffinanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tffinanzas.dtos.CuotaDTO;
import pe.edu.upc.tffinanzas.entities.Cuota;
import pe.edu.upc.tffinanzas.servicesinterfaces.ICuotaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Cuotas")
public class CuotaController {
    @Autowired
    private ICuotaService cR;

    @PutMapping
    public void editar(@RequestBody CuotaDTO dto){
        ModelMapper m = new ModelMapper();
        Cuota cp = m.map(dto, Cuota.class);
        cR.insert(cp);
    }

    @GetMapping
    public List<CuotaDTO> Listar(){
        return cR.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, CuotaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/listarporfactura/{id}")
    public List<CuotaDTO>ListarByFactura(@PathVariable("id") int id){
        return cR.listCanceladoByFactura(id).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, CuotaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        cR.delete(id);
    }

    @GetMapping("/{id}")
    public CuotaDTO listarId(@PathVariable("id") int id){
        ModelMapper m =new ModelMapper();
        CuotaDTO dto=m.map(cR.listId(id), CuotaDTO.class);
        return dto;
    }
}
