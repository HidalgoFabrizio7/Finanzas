package pe.edu.upc.finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.finanzas.entities.Role;
import pe.edu.upc.finanzas.repositories.IRoleRepository;
import pe.edu.upc.finanzas.servicesinterfaces.IRoleService;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
        private IRoleRepository rolR;


    @Override
    public void Registrar(Role rol) {
        rolR.save(rol);
    }

    @Override
    public List<Role> list() {
        return rolR.findAll();
    }

    @Override
    public void Eliminar(Long idRol) {
        rolR.deleteById(idRol);
    }

    @Override
    public Role ListarId(Long idRol) {
        return rolR.findById(idRol).orElse(new Role());
    }
}
