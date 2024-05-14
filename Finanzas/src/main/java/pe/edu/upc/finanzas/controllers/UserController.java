package pe.edu.upc.finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.finanzas.dtos.UsuarioClienteDTO;
import pe.edu.upc.finanzas.entities.Users;
import pe.edu.upc.finanzas.servicesinterfaces.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private IUserService useS;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/registrar")
    public void registrar(@RequestBody UsuarioClienteDTO dto){
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        useS.Registrar(u);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody UsuarioClienteDTO dto){
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        useS.Registrar(u);
    }

    @GetMapping
    public List<UsuarioClienteDTO> ListarUsuariosCliente(){
        return useS.ListarUsuariosCliente().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, UsuarioClienteDTO.class);
        }).collect(Collectors.toList());
    }

}
