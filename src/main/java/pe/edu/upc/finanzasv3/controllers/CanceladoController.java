package pe.edu.upc.finanzasv3.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.finanzasv3.dtos.CanceladoDTO;
import pe.edu.upc.finanzasv3.dtos.FacturaDTO;
import pe.edu.upc.finanzasv3.dtos.UsuarioCompletoDTO;
import pe.edu.upc.finanzasv3.entities.Cancelado;
import pe.edu.upc.finanzasv3.repositories.ICanceladoRepository;
import pe.edu.upc.finanzasv3.serviceinterface.ICanceladoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Cancelaciones")
public class CanceladoController {
    @Autowired
    private ICanceladoService cR;
    
    @PostMapping
    public void registrar(@RequestBody CanceladoDTO dto) {
        ModelMapper m = new ModelMapper();
        Cancelado cp = m.map(dto, Cancelado.class);
        cR.insert(cp);
    }

    @PutMapping
    public void editar(@RequestBody CanceladoDTO dto){
        ModelMapper m = new ModelMapper();
        Cancelado cp = m.map(dto, Cancelado.class);
        cR.insert(cp);
    }

    @GetMapping
    public List<CanceladoDTO>Listar(){
        return cR.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, CanceladoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping
    public List<CanceladoDTO>ListarByFactura(@PathVariable int id){
        return cR.listCanceladoByFactura(id).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, CanceladoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        cR.delete(id);
    }

    @GetMapping("/{id}")
    public CanceladoDTO listarId(@PathVariable("id") int id){
        ModelMapper m =new ModelMapper();
        CanceladoDTO dto=m.map(cR.listId(id), CanceladoDTO.class);
        return dto;
    }


}
