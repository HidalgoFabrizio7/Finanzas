package pe.edu.upc.finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.finanzas.dtos.UsuarioClienteDTO;
import pe.edu.upc.finanzas.dtos.UsuarioCompletoDTO;
import pe.edu.upc.finanzas.dtos.UsuarioDTO;
import pe.edu.upc.finanzas.entities.Users;

import java.util.List;

public interface IUserRepository extends JpaRepository<Users, Long> {
    public Users findByUsername(String username);

    @Query(value = "SELECT u.* FROM users u \n" +
    "join roles r on r.user_id = u.id \n" +
    "where r.rol = 'CLIENTE' \n" +
    "order by u.id asc ", nativeQuery = true)
        public List<UsuarioClienteDTO>  UsuarioPorRoleCliente();


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

}
