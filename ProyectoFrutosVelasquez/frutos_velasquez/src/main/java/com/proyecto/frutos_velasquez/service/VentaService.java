package com.proyecto.frutos_velasquez.service;

import com.proyecto.frutos_velasquez.model.*;
import com.proyecto.frutos_velasquez.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.LocalDateTime;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private WebClient.Builder webClientBuilder;

    public Venta procesarVenta(Venta venta) {
        double totalVenta = 0;
        for (DetalleVenta detalle : venta.getDetalles()) {
            // Llamada al micro de Catálogo (Asegúrate que el puerto 8082 esté activo)
            Double precio = webClientBuilder.build().get()
                .uri("http://localhost:8082/api/v1/productos/precio/" + detalle.getProductoId())
                .retrieve().bodyToMono(Double.class).block();

            detalle.setSubtotal(precio * detalle.getCantidad());
            totalVenta += detalle.getSubtotal();
            detalle.setVenta(venta);
        }
        venta.setTotal(totalVenta);
        venta.setFechaHora(LocalDateTime.now());
        return ventaRepository.save(venta);
    }
}