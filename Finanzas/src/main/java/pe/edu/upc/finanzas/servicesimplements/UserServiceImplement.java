package pe.edu.upc.finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.finanzas.dtos.UsuarioClienteDTO;
import pe.edu.upc.finanzas.entities.Users;
import pe.edu.upc.finanzas.repositories.IUserRepository;
import pe.edu.upc.finanzas.servicesinterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    public IUserRepository useR;

    @Override
    public void Registrar(Users usuario) {
        useR.save(usuario);
    }

    @Override
    public List<UsuarioClienteDTO> ListarUsuariosCliente() {
        return useR.UsuarioPorRoleCliente();
    }

    @Override
    public Users ListarId(Long idUsuario) {
        return useR.findById(idUsuario).orElse(new Users());
    }
}
