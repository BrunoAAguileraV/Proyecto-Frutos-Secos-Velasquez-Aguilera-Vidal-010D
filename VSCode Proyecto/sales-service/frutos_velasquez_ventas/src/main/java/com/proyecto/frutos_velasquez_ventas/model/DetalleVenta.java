package com.proyecto.frutos_velasquez_ventas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;
    private Long idProducto;
    private Double cantidad;
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    @JsonIgnore
    private Venta venta;
}
