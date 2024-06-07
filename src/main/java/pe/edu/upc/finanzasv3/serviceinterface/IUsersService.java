package pe.edu.upc.finanzasv3.serviceinterface;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.finanzasv3.dtos.ClienteDTO;
import pe.edu.upc.finanzasv3.entities.Users;

import java.util.List;

public interface IUsersService {
    public List<Users> ListCliente();
    public void insert(Users users);
    public void delete(Long id);
    public Users listId(Long id);
    public void insRol(String authority, Long user_id);
}
