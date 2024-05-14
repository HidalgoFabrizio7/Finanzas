package pe.edu.upc.finanzas.servicesinterfaces;

import pe.edu.upc.finanzas.entities.Role;

import java.util.List;

public interface IRoleService {
    public void Registrar(Role rol);

    public List<Role> list();

    public void Eliminar(Long idRol);

    public Role ListarId(Long idRol);

}
