package pe.edu.upc.tffinanzas.servicesimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.tffinanzas.entities.Role;
import pe.edu.upc.tffinanzas.servicesinterfaces.IRoleService;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Override
    public void insert(Role rol) {

    }

    @Override
    public List<Role> list() {
        return List.of();
    }

    @Override
    public void delete(Long idRol) {

    }

    @Override
    public Role listarId(Long idRol) {
        return null;
    }
}
