package com.proyecto.frutos_velasquez_inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.frutos_velasquez_inventario.repository.StockRepository;
import com.proyecto.frutos_velasquez_inventario.modelo.Stock;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> listarTodo(){
        return stockRepository.findAll();
    }

    public Optional<Stock> buscarPorId(Long id){
        return stockRepository.findById(id);
    }

    public Stock guardar(Stock stock){
        return stockRepository.save(stock);
    }

    public List<Stock> buscarProductoStockExacto(Double cantidad){
        return stockRepository.findByStockActual(cantidad);
    }

    public List<Stock> productosBajoStock(Double limite){
        return stockRepository.findByStockActualLessThan(limite);
    }

    public Optional<Stock> buscarPorProducto(Long idProducto){
        return stockRepository.findByIdProducto(idProducto);
    }

    public void eliminar(Long id){
        stockRepository.deleteById(id);
    }

}
