package pe.edu.upc.finanzasv3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.finanzasv3.entities.Cancelado;

@Repository
public interface ICanceladoRepository extends JpaRepository<Cancelado, Integer> {

}
