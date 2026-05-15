package com.proyecto.frutos_velasquez_ventas.controller;

import com.proyecto.frutos_velasquez_ventas.model.Venta;
import com.proyecto.frutos_velasquez_ventas.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {
        return ventaService.procesarVenta(venta);
    }

    @GetMapping("/total-dia/{fecha}")
    public Double obtenerTotalDia(@PathVariable String fecha) {
        return ventaService.obtenerTotalVentasDia(LocalDate.parse(fecha));
    }
}
