package pe.edu.upc.finanzas.servicesinterfaces;

import pe.edu.upc.finanzas.dtos.UsuarioClienteDTO;
import pe.edu.upc.finanzas.entities.Users;

import java.util.List;

public interface IUserService {
    public void Registrar(Users usuario);

    public List<UsuarioClienteDTO> ListarUsuariosCliente();

    public Users ListarId(Long idUsuario);

}
