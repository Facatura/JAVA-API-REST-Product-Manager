package com.cafechul.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Inventarios")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidadDisponible;
    private LocalDateTime ultimaActualizacion;

// Relación ManyToMany con Producto
@ManyToMany
@JoinTable(                         //Especifica la tabla intermedia que se utilizará para gestionar la relación ManyToMany con claves foraneas.
    name = "productoInventario", // Nombre de la tabla intermedia
    joinColumns = @JoinColumn(name = "inventarioId"), // Clave foránea para la entidad actual
    inverseJoinColumns = @JoinColumn(name = "productoId") // Clave foránea para la otra entidad (Producto)
)
private List<Producto> productos; // Cambiar a una lista

}

