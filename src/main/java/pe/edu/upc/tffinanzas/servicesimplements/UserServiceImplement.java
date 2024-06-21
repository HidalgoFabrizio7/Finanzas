package pe.edu.upc.tffinanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tffinanzas.entities.Users;
import pe.edu.upc.tffinanzas.repositories.IUserRepository;
import pe.edu.upc.tffinanzas.servicesinterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;

    @Override
    public void insert(Users usuario) {
        uR.save(usuario);
    }

    @Override
    public List<Users> list() {
        return uR.ListCliente();
    }

    @Override
    public void delete(Long idUsuario) {
        uR.deleteById(idUsuario);
    }

    @Override
    public Users listarId(Long idUsuario) {
        return uR.findById(idUsuario).orElse(new Users());
    }

    @Override
    public Boolean existeNombre(String username) {
        return uR.existsByUsername(username);
    }

    @Override
    public void insertRol(String rol, Long idUsuario) {
        uR.insRol(rol, idUsuario);
    }
}
