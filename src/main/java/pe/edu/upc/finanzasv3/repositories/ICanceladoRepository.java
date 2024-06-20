package pe.edu.upc.finanzasv3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.finanzasv3.entities.Cancelado;
import pe.edu.upc.finanzasv3.entities.Factura;

import java.util.List;

@Repository
public interface ICanceladoRepository extends JpaRepository<Cancelado, Integer> {
    @Query(value = "SELECT c.*\n" +
            "FROM cancelado c\n" +
            "join factura f on f.user_id = c.id_factura\n" +
            "join users u on u.id = f.user_id\n" +
            "join roles r on r.user_id = u.id\n" +
            "where r.rol = 'CLIENTE'\n" +
            "and f.id_factura = :idFactura\n" +
            "and u.enabled = TRUE\n" +
            "order by f.fecha_factura asc", nativeQuery = true)
    public List<Cancelado> listCanceladoByFactura(@Param("idFactura") int idFactura);
}
