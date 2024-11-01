package com.cafechul.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "CarrosDeCompras")
public class CarroDeCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaCreacion; 

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;        // Relacion 1 a 1 con Usuario

    @OneToMany(mappedBy = "carroDeCompras")
    private List<ElementoDelCarro>ElementoDelCarro; // Relación uno a muchos con ElementoDelCarro
}
