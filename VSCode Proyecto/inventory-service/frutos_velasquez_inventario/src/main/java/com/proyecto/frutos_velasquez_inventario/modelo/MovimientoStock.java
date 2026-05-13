package com.proyecto.frutos_velasquez_inventario.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movimiento_stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimiento;
    private String tipo_movimiento;//COMPRA, VENTA, MERMA
    private Double cantidad;

}
