package com.proyecto.frutos_velasquez.controller;

import com.proyecto.frutos_velasquez.model.Venta;
import com.proyecto.frutos_velasquez.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping
    public Venta realizarVenta(@RequestBody Venta venta) {
        return ventaService.procesarVenta(venta);
    }
}