package com.proyecto.frutos_velasquez_compras.repository;

import com.proyecto.frutos_velasquez_compras.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    // findById ya viene por defecto
}
