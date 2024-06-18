package pe.edu.upc.finanzasv3.serviceinterface;

import pe.edu.upc.finanzasv3.entities.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role rol);

    public List<Role> list();

    public void delete(Long idRol);

    public Role listarId(Long idRol);

}
