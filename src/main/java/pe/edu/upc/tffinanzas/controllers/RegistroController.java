package pe.edu.upc.tffinanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.tffinanzas.dtos.UserDTO;
import pe.edu.upc.tffinanzas.entities.Users;
import pe.edu.upc.tffinanzas.servicesinterfaces.IUserService;

@RestController
@RequestMapping("/registro")
public class RegistroController {
    @Autowired
    private IUserService uS;
    @PostMapping
    public void registrar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        uS.insert(u);
        uS.insertRol("CLIENTE", u.getId());
    }
}
