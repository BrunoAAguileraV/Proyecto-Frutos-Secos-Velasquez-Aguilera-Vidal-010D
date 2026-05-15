package com.proyecto.frutos_velasquez_ventas.repository;

import com.proyecto.frutos_velasquez_ventas.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    // Consulta para el micro de Analítica (RF08)
    @Query("SELECT SUM(v.total) FROM Venta v WHERE v.fechaHora BETWEEN :inicio AND :fin")
    Double sumarTotalPorRango(@Param("inicio") LocalDateTime inicio, @Param("fin") LocalDateTime fin);
}
