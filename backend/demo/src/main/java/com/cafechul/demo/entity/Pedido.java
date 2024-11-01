package com.cafechul.demo.entity;

import java.time.LocalDateTime;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Pedidos")

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaCreacion;
    private float precioFinal;
    @Column(length = 20)
    private String estado;

            // Relación ManyToOne con Usuarios (clientes)
        @ManyToOne
        @JoinColumn(name = "clientes_id")
        private Usuario usuario; 
        
                // Relación uno a muchos con detalles de pedido
        @OneToMany(mappedBy = "pedido")
        private List<DetallesPedido> detalles;
    }

