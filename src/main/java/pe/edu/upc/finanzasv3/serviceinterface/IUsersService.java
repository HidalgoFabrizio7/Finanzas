package pe.edu.upc.finanzasv3.serviceinterface;

import pe.edu.upc.finanzasv3.dtos.ClienteDTO;
import pe.edu.upc.finanzasv3.entities.Users;

import java.util.List;

public interface IUsersService {
    public List<Users> ListCliente();
}
