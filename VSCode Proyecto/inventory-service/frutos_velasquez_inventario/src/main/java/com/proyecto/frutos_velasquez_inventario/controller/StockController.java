package com.proyecto.frutos_velasquez_inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.frutos_velasquez_inventario.modelo.Stock;
import com.proyecto.frutos_velasquez_inventario.service.StockService;

@RestController
@RequestMapping("/api/v1/inventario")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    private List<Stock> listarTodo(){
        return stockService.listarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> buscarPorId(@PathVariable Long id){
        return stockService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<Stock> buscarPorProducto(@PathVariable Long idProducto){
        return stockService.buscarPorProducto(idProducto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    } 

    @GetMapping("/alertas")
    public List<Stock> alertaBajoStock(@RequestParam Double limite){
        return stockService.productosBajoStock(limite);
    }

    @PostMapping
    public ResponseEntity<Stock> crearRegistroStock(@RequestBody Stock stock) {
        // Usamos el método guardar que ya tienes en tu StockService
        Stock nuevoStock = stockService.guardar(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoStock);
    }

}
