package com.proyecto.frutos_velasquez.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categoría")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre; //Frutos secos, semillas, etc.

}
