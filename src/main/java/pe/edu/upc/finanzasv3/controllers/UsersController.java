package pe.edu.upc.finanzasv3.controllers;

import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.finanzasv3.dtos.ClienteDTO;
import pe.edu.upc.finanzasv3.dtos.FacturaDTO;
import pe.edu.upc.finanzasv3.dtos.UsuarioCompletoDTO;
import pe.edu.upc.finanzasv3.entities.Factura;
import pe.edu.upc.finanzasv3.entities.Users;
import pe.edu.upc.finanzasv3.serviceinterface.IUsersService;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsersController {
    @Autowired
    private IUsersService usersS;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //LISTAR CLIENTES
    @GetMapping
    public List<UsuarioCompletoDTO> ListClientes() {
        return usersS.ListCliente().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioCompletoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void registrar(@RequestBody UsuarioCompletoDTO dto) {
        ModelMapper m = new ModelMapper();
        Users up = m.map(dto, Users.class);
        String encodedPassword = passwordEncoder.encode(up.getPassword());
        up.setPassword(encodedPassword);
        usersS.insertRol("CLIENTE", up.getId());
        usersS.insert(up);
    }
    @PutMapping
    public void editar(@RequestBody UsuarioCompletoDTO usuarioDTO){
        ModelMapper m = new ModelMapper();
        Users g=m.map(usuarioDTO, Users.class);
        usersS.insert(g);
    }


    //@PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        usersS.delete(id);
    }

    @GetMapping("/{id}")
    public UsuarioCompletoDTO listarId(@PathVariable("id") Long id){
        ModelMapper m =new ModelMapper();
        UsuarioCompletoDTO dto=m.map(usersS.listId(id), UsuarioCompletoDTO.class);
        return dto;
    }

    @GetMapping("/")
    public ResponseEntity<Boolean> usuarioEnUso(@RequestParam String username){
        boolean exits = usersS.existeNombre(username);
        return ResponseEntity.ok(exits);
    }


}
