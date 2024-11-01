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
@Entity(name = "detallesPedidos")
public class DetallesPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cantidad;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido; // Relación muchos a uno con Pedido

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto; // Relación muchos a uno con Pedido
}
