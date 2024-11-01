package com.cafechul.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float precio;

        // Relación ManyToOne con Tamanio
        @ManyToOne
        @JoinColumn(name = "tamanio_id")  // Nombre de la columna en la tabla Product
        private Tamanio tamanio;

        // Relación ManyToOne con TipoCafe
        @ManyToOne
        @JoinColumn(name = "tipo_cafe_id")  // Nombre de la columna en la tabla Product
        private TipoCafe tipoCafe;

        // Relacion ManyToMany con Inventario
        @ManyToMany(mappedBy = "productos") //se refiere específicamente al nombre de la propiedad productos en la clase Inventario, que es la que define el lado propietario de la relación.
        private List<Inventario> inventarios;






    }



