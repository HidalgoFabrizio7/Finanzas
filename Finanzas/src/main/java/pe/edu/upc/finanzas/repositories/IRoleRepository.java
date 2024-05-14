package pe.edu.upc.finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.finanzas.dtos.RolDTO;
import pe.edu.upc.finanzas.dtos.UsuarioCompletoDTO;
import pe.edu.upc.finanzas.entities.Role;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

}
