package com.proyecto.frutos_velasquez.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;
    private Long productoId; 
    private Double cantidad;
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    @JsonIgnore 
    private Venta venta;
}