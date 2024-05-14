package pe.edu.upc.finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.finanzas.dtos.FacturaDTO;
import pe.edu.upc.finanzas.dtos.UsuarioCompletoDTO;
import pe.edu.upc.finanzas.entities.Factura;

import java.util.List;

@Repository
public interface IFacturaRepository extends JpaRepository<Factura, Integer> {
    @Query(value = "SELECT f.* FROM factura f\n" +
            "join users u on u.id = f.user_id\n" +
            "join roles r on r.user_id = u.id\n" +
            "where r.rol = 'CLIENTE' and f.estado_factura = 'POR CANCELAR' and u.id = :idUsuario\n" +
            "order by f.id_factura asc", nativeQuery = true)
    public List<FacturaDTO> FacturasPorUsuarioSinCancelar(@Param("idUsuario") Long idUsuario);

    public Factura findFacturaByUserUsername (String username);
}
