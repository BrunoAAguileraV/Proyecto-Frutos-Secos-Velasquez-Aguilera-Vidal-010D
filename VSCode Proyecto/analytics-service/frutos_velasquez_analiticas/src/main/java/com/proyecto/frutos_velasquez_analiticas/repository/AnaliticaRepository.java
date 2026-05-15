package com.proyecto.frutos_velasquez_analiticas.repository;

import com.proyecto.frutos_velasquez_analiticas.model.ResumenDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliticaRepository extends JpaRepository<ResumenDiario, Long> {
}
