package com.proyecto.frutos_velasquez_analiticas.controller;

import com.proyecto.frutos_velasquez_analiticas.model.ResumenDiario;
import com.proyecto.frutos_velasquez_analiticas.service.AnaliticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/analitica")
public class AnaliticaController {

    @Autowired
    private AnaliticaService analiticaService;

    @GetMapping("/reporte")
    public ResponseEntity<ResumenDiario> obtenerReporte(
            // Le decimos a Spring que espere una fecha formato YYYY-MM-DD
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        
        // Ejecutamos el servicio, el cual ahora está protegido contra los 404 de Ventas
        ResumenDiario reporte = analiticaService.generarReporteDiario(fecha);
        
        // Devolvemos el reporte con un código HTTP 200 (OK)
        return ResponseEntity.ok(reporte);
    }
}
