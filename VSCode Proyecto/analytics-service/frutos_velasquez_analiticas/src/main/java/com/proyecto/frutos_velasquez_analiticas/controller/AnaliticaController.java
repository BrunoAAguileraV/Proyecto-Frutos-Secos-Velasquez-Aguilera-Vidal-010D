package com.proyecto.frutos_velasquez_analiticas.controller;

import com.proyecto.frutos_velasquez_analiticas.model.ResumenDiario;
import com.proyecto.frutos_velasquez_analiticas.service.AnaliticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/analitica")
public class AnaliticaController {

    @Autowired
    private AnaliticaService analiticaService;

    @GetMapping("/reporte")
    public ResumenDiario obtenerReporte(@RequestParam String fecha) {
        // Ejemplo de uso: /api/v1/analitica/reporte?fecha=2024-05-13
        return analiticaService.generarReporteDiario(LocalDate.parse(fecha));
    }
}
