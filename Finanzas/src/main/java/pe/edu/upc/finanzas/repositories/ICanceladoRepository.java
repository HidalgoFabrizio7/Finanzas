package pe.edu.upc.finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.finanzas.dtos.CanceladoDTO;
import pe.edu.upc.finanzas.dtos.FacturaDTO;
import pe.edu.upc.finanzas.entities.Cancelado;

import java.util.List;

@Repository
public interface ICanceladoRepository extends JpaRepository<Cancelado, Integer> {
    @Query(value = "SELECT c.* FROM cancelado c\n" +
            "join factura f on f.id_factura = c.id_factura\n" +
            "join users u on u.id = f.user_id\n" +
            "join roles r on r.user_id = u.id\n" +
            "where r.rol = 'CLIENTE'and f.id_factura = :idFactura\n" +
            "order by c.id_cancelado asc ", nativeQuery = true)
    public List<CanceladoDTO> CancelacionesPorFactura(@Param("idFactura") Integer idFactura);

}
