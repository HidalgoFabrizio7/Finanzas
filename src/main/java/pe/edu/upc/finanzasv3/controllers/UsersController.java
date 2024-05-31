package pe.edu.upc.finanzasv3.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.finanzasv3.dtos.ClienteDTO;
import pe.edu.upc.finanzasv3.serviceinterface.IUsersService;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsersController {
    @Autowired
    private IUsersService usersS;

    //LISTAR CLIENTES
    @GetMapping
    public List<ClienteDTO> ListCliente() {
        return usersS.ListCliente().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ClienteDTO.class);
        }).collect(Collectors.toList());
    }
}
