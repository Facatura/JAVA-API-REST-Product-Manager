package com.cafechul.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "ElementosDelCarro")
public class ElementoDelCarro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long Cantidad;

    @ManyToOne
    @JoinColumn(name = "carroDeCompras_id")
    private CarroDeCompras carroDeCompras; // Relación muchos a uno con CarroDeCompras

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
}
