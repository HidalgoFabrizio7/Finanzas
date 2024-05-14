package pe.edu.upc.finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.finanzas.dtos.RolDTO;
import pe.edu.upc.finanzas.entities.Role;
import pe.edu.upc.finanzas.servicesinterfaces.IRoleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rol")
public class RoleController {
    @Autowired
    private IRoleService rolS;

    @PostMapping("/registrar")
    public void registrar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(dto, Role.class);
        rolS.Registrar(r);
    }

    @PutMapping
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(dto, Role.class);
        rolS.Registrar(r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        rolS.Eliminar(id);
    }

    @GetMapping("/{id}")
    public RolDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(rolS.ListarId(id), RolDTO.class);
        return dto;
    }

    @GetMapping
    public List<RolDTO> listar() {
        return rolS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }
}
