package pe.edu.upc.tffinanzas.servicesinterfaces;

import pe.edu.upc.tffinanzas.entities.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role rol);

    public List<Role> list();

    public void delete(Long idRol);

    public Role listarId(Long idRol);

}
