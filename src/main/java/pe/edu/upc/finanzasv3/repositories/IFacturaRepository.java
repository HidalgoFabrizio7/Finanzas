package pe.edu.upc.finanzasv3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.finanzasv3.dtos.ListaFacturaAminDTO;
import pe.edu.upc.finanzasv3.entities.Factura;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IFacturaRepository extends JpaRepository <Factura, Integer> {
    //PARA USER 'ADMIN' LOGUEADO
    @Query(value = "SELECT ROW_NUMBER() OVER (ORDER BY f.fecha_factura asc) AS row_number,\n" +
            "u.username as Cliente,\n" +
            "f.fecha_factura as FechaPrestamo,\n" +
            "f.monto_prestamo as Monto,\n" +
            "f.tipo_tasa as TasaInteres,\n" +
            "f.tasa as PorcentajeTasa,\n" +
            "f.plazo_pago as Periodo,\n" +
            "f.estado_factura as Estado,\n" +
            "f.responsable_factura as Cajero\n" +
            "FROM factura f\n" +
            "join users u on u.id = f.user_id\n" +
            "join roles r on r.user_id = u.id\n" +
            "where r.rol = 'CLIENTE'\n" +
            "and u.enabled = TRUE\n" +
            "order by f.fecha_factura asc", nativeQuery = true)
    public List<String[]> listarFacturaPersonalizadaAdmin();
    //FILTROS
    //POR FECHA
    @Query(value = "SELECT ROW_NUMBER() OVER (ORDER BY f.fecha_factura asc) AS row_number,\n" +
            "u.username as Cliente,\n" +
            "f.fecha_factura as FechaPrestamo,\n" +
            "f.monto_prestamo as Monto,\n" +
            "f.tipo_tasa as TasaInteres,\n" +
            "f.tasa as PorcentajeTasa,\n" +
            "f.plazo_pago as Periodo,\n" +
            "f.estado_factura as Estado,\n" +
            "f.responsable_factura as Cajero\n" +
            "FROM factura f\n" +
            "join users u on u.id = f.user_id\n" +
            "join roles r on r.user_id = u.id\n" +
            "where r.rol = 'CLIENTE'\n" +
            "and f.fecha_factura > :fecha \n" +
            "and u.enabled = TRUE\n" +
            "order by f.fecha_factura asc", nativeQuery = true)
    public List<String[]> FiltroPorFechalistarFacturaPersonalizadaAdmin(@Param("fecha") LocalDate fecha);

    //POR ESTADO
    @Query(value = "SELECT ROW_NUMBER() OVER (ORDER BY f.fecha_factura asc) AS row_number,\n" +
            "u.username as Cliente,\n" +
            "f.fecha_factura as FechaPrestamo,\n" +
            "f.monto_prestamo as Monto,\n" +
            "f.tipo_tasa as TasaInteres,\n" +
            "f.tasa as PorcentajeTasa,\n" +
            "f.plazo_pago as Periodo,\n" +
            "f.estado_factura as Estado,\n" +
            "f.responsable_factura as Cajero\n" +
            "FROM factura f\n" +
            "join users u on u.id = f.user_id\n" +
            "join roles r on r.user_id = u.id\n" +
            "where r.rol = 'CLIENTE'\n" +
            "and f.estado_factura = :estado \n" +
            "and u.enabled = TRUE\n" +
            "order by f.fecha_factura asc", nativeQuery = true)
    public List<String[]> FiltroPorEstadolistarFacturaPersonalizadaAdmin(@Param("estado") String estado);



    //PARA USER 'CLIENTE' LOGUEADO
    @Query(value = "SELECT ROW_NUMBER() OVER (ORDER BY f.fecha_factura asc) AS row_number,\n" +
            "u.username as Cliente,\n" +
            "f.fecha_factura as FechaPrestamo,\n" +
            "f.monto_prestamo as Monto,\n" +
            "f.tipo_tasa as TasaInteres,\n" +
            "f.tasa as PorcentajeTasa,\n" +
            "f.plazo_pago as Periodo,\n" +
            "f.estado_factura as Estado,\n" +
            "f.responsable_factura as Cajero\n" +
            "FROM factura f\n" +
            "join users u on u.id = f.user_id\n" +
            "join roles r on r.user_id = u.id\n" +
            "where r.rol = 'CLIENTE'\n" +
            "and u.id = :idUsuario \n" +
            "and u.enabled = TRUE\n" +
            "order by f.fecha_factura asc", nativeQuery = true)
    public List<String[]> listarFacturaPersonalizadaCliente(@Param("idUsuario") Long idUsuario);
    //FILTROS
    //POR FECHA
    @Query(value = "SELECT ROW_NUMBER() OVER (ORDER BY f.fecha_factura asc) AS row_number,\n" +
            "u.username as Cliente,\n" +
            "f.fecha_factura as FechaPrestamo,\n" +
            "f.monto_prestamo as Monto,\n" +
            "f.tipo_tasa as TasaInteres,\n" +
            "f.tasa as PorcentajeTasa,\n" +
            "f.plazo_pago as Periodo,\n" +
            "f.estado_factura as Estado,\n" +
            "f.responsable_factura as Cajero\n" +
            "FROM factura f\n" +
            "join users u on u.id = f.user_id\n" +
            "join roles r on r.user_id = u.id\n" +
            "where r.rol = 'CLIENTE'\n" +
            "and u.id = :idUsuario \n" +
            "and f.fecha_factura > :fecha \n" +
            "and u.enabled = TRUE\n" +
            "order by f.fecha_factura asc", nativeQuery = true)
    public List<String[]> FiltroPorFechalistarFacturaPersonalizadaCliente(@Param("idUsuario") Long idUsuario, @Param("fecha") LocalDate fecha);

    //POR ESTADO
    @Query(value = "SELECT ROW_NUMBER() OVER (ORDER BY f.fecha_factura asc) AS row_number,\n" +
            "u.username as Cliente,\n" +
            "f.fecha_factura as FechaPrestamo,\n" +
            "f.monto_prestamo as Monto,\n" +
            "f.tipo_tasa as TasaInteres,\n" +
            "f.tasa as PorcentajeTasa,\n" +
            "f.plazo_pago as Periodo,\n" +
            "f.estado_factura as Estado,\n" +
            "f.responsable_factura as Cajero\n" +
            "FROM factura f\n" +
            "join users u on u.id = f.user_id\n" +
            "join roles r on r.user_id = u.id\n" +
            "where r.rol = 'CLIENTE'\n" +
            "and u.id = :idUsuario \n" +
            "and f.estado_factura = :estado \n" +
            "and u.enabled = TRUE\n" +
            "order by f.fecha_factura asc", nativeQuery = true)
    public List<String[]> FiltroPorEstadolistarFacturaPersonalizadaCliente(@Param("idUsuario") Long idUsuario, @Param("estado") String estado);


}
