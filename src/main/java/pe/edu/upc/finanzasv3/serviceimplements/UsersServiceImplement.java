package pe.edu.upc.finanzasv3.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.finanzasv3.dtos.ClienteDTO;
import pe.edu.upc.finanzasv3.entities.Users;
import pe.edu.upc.finanzasv3.repositories.IUserRepository;
import pe.edu.upc.finanzasv3.serviceinterface.IUsersService;

import java.util.List;

@Service
public class UsersServiceImplement implements IUsersService {
    @Autowired
    private IUserRepository userR;

    @Override
    public List<Users> ListCliente() {
        return userR.ListCliente();
    }

    @Override
    public void insert(Users users) {
        userR.save(users);
        userR.insRol("CLIENTE",users.getId());
    }

    @Override
    public void delete(Long id) {
        userR.deleteById(id);
    }

    @Override
    public Users listId(Long id) {
        return userR.findById(id).orElse(new Users());
    }

    @Override
    public void insRol(String authority, Long user_id) {
        userR.insRol(authority, user_id);
    }

}
