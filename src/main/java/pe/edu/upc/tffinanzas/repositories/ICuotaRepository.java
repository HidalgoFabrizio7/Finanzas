package pe.edu.upc.tffinanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tffinanzas.entities.Cuota;

import java.util.List;

@Repository
public interface ICuotaRepository extends JpaRepository<Cuota, Integer> {
    @Query(value = "SELECT c.*\n" +
            "FROM cuotas c\n" +
            "join facturas f on f.user_id = c.id_factura\n" +
            "join users u on u.id = f.user_id\n" +
            "join roles r on r.user_id = u.id\n" +
            "where r.rol = 'CLIENTE'\n" +
            "and f.id_factura = :idFactura \n" +
            "and u.enabled = TRUE\n" +
            "order by f.fecha_factura asc", nativeQuery = true)
    public List<Cuota> listCuotaByFactura(@Param("idFactura") int idFactura);

}
