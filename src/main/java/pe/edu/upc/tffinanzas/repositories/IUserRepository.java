package pe.edu.upc.tffinanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.tffinanzas.entities.Users;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {
    //LISTAR CLIENTE

    @Query(value = "select u.* FROM users u \n" +
            "join roles r on r.user_id = u.id \n" +
            "where r.rol = 'CLIENTE' and u.enabled = true \n" +
            "order by u.id asc ", nativeQuery = true)
    public List<Users> ListCliente();

    //INSERTAR ROLES

    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

    public Users findByUsername(String username);
    public Boolean existsByUsername(String username);
}
