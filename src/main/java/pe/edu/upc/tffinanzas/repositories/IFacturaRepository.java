package pe.edu.upc.tffinanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tffinanzas.entities.Factura;

import java.util.List;

@Repository
public interface IFacturaRepository extends JpaRepository<Factura, Integer> {
    //LISTAR factura
    @Query(value = "SELECT f.*\n" +
            "FROM facturas f\n" +
            "join users u on u.id = f.user_id\n" +
            "join roles r on r.user_id = u.id\n" +
            "where r.rol = 'CLIENTE'\n" +
            "and u.id = :idUsuario\n" +
            "and u.enabled = TRUE\n" +
            "order by f.fecha_factura asc", nativeQuery = true)
    public List<Factura> ListFacturasByCliente(@Param("idUsuario") Long idUsuario);

    @Query(value = "SELECT f.*\n" +
            "FROM facturas f\n" +
            "join users u on u.id = f.user_id\n" +
            "join roles r on r.user_id = u.id\n" +
            "where r.rol = 'CLIENTE'\n" +
            "and u.enabled = TRUE\n" +
            "order by f.fecha_factura asc", nativeQuery = true)
    public List<Factura> ListFacturas();
}
