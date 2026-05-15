package com.proyecto.frutos_velasquez_analiticas.service;

import com.proyecto.frutos_velasquez_analiticas.model.ResumenDiario;
import com.proyecto.frutos_velasquez_analiticas.repository.AnaliticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.LocalDate;

@Service
public class AnaliticaService {
    
    @Autowired
    private AnaliticaRepository analiticaRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public ResumenDiario generarReporteDiario(LocalDate fecha) {
        // Consultamos al micro de Ventas (8083)
        Double ingresos = webClientBuilder.build().get()
            .uri("http://localhost:8083/api/v1/ventas/total-dia/" + fecha)
            .retrieve()
            .bodyToMono(Double.class)
            .block();

        // Consultamos al micro de Suministros (8086) - Si aún no existe, devolverá 0
        Double costos = 0.0; 

        ResumenDiario reporte = new ResumenDiario();
        reporte.setFecha(fecha);
        reporte.setIngresosTotales(ingresos != null ? ingresos : 0.0);
        reporte.setCostosTotales(costos);
        reporte.setUtilidadNeta(reporte.getIngresosTotales() - reporte.getCostosTotales());

        return analiticaRepository.save(reporte);
    }
}
