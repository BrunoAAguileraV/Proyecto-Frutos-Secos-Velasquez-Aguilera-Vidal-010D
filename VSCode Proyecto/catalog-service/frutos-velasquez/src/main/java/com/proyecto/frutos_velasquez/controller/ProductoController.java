package com.proyecto.frutos_velasquez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.frutos_velasquez.service.ProductoService;
import com.proyecto.frutos_velasquez.model.Producto;

@RestController
@RequestMapping("api/v1/catalogo/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listar(){
        return productoService.listarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtener(@PathVariable Long id){
        return productoService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        productoService.Eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
