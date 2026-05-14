package com.proyecto.frutos_velasquez_inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.frutos_velasquez_inventario.modelo.MovimientoStock;
import com.proyecto.frutos_velasquez_inventario.repository.MovStockRepository;

@Service
public class MovStockService {

    @Autowired
    private MovStockRepository movStockRepository;

    public List<MovimientoStock> listarTodo(){
        return movStockRepository.findAll();
    }

    public Optional<MovimientoStock> encontrarPorId(Long idMovimiento){
        return movStockRepository.findByIdMovimiento(idMovimiento);
    }

    public void eliminar(Long id){
        movStockRepository.deleteById(id);
    }

    public MovimientoStock guardar(MovimientoStock movStock){
        return movStockRepository.save(movStock);
    }

    public List<MovimientoStock> tipoDeMovimiento(String tipo_movimiento){
        return movStockRepository.findByTipo_movimientoIgnoreCase(tipo_movimiento);
    }

}
