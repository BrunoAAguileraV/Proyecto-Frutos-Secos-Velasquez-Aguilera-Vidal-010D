package com.proyecto.frutos_velasquez.repository;

import com.proyecto.frutos_velasquez.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
}