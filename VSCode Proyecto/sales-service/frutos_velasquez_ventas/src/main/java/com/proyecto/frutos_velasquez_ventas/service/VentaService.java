package com.proyecto.frutos_velasquez_ventas.service;

import com.proyecto.frutos_velasquez_ventas.model.*;
import com.proyecto.frutos_velasquez_ventas.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.*;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Venta procesarVenta(Venta venta) {
        double totalVenta = 0;
        for (DetalleVenta detalle : venta.getDetalles()) {
            // Llama al catálogo para obtener precio real
            Double precio = webClientBuilder.build().get()
                .uri("http://localhost:8082/api/v1/productos/precio/" + detalle.getProductoId())
                .retrieve().bodyToMono(Double.class).block();

            detalle.setSubtotal((precio != null ? precio : 0.0) * detalle.getCantidad());
            totalVenta += detalle.getSubtotal();
            detalle.setVenta(venta);
        }
        venta.setTotal(totalVenta);
        venta.setFechaHora(LocalDateTime.now());
        return ventaRepository.save(venta);
    }

    public Double obtenerTotalVentasDia(LocalDate fecha) {
        return ventaRepository.sumarTotalPorRango(fecha.atStartOfDay(), fecha.atTime(LocalTime.MAX));
    }
}
