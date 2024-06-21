package pe.edu.upc.tffinanzas.servicesinterfaces;

import pe.edu.upc.tffinanzas.entities.Users;

import java.util.List;

public interface IUserService {
    public void insert(Users usuario);

    public List<Users> list();

    public void delete(Long idUsuario);

    public Users listarId(Long idUsuario);

    public Boolean existeNombre(String username);

    public void insertRol(String rol, Long idUsuario);
}
