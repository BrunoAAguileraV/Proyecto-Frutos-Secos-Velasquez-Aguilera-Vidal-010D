package com.proyecto.frutos_velasquez_inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.frutos_velasquez_inventario.modelo.MovimientoStock;

import java.util.List;
import java.util.Optional;


@Repository
public interface MovStockRepository extends JpaRepository<MovimientoStock, Long>{

    Optional<MovimientoStock> findByIdMovimiento(Long idMovimiento);

    List<MovimientoStock> findByTipo_movimientoIgnoreCase(String tipo_movimiento);

}
