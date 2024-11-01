package com.cafechul.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String nombre;
    @Column(length = 30)
    private String apellido;
    @Column(length = 50)
    private String correo;
    @Column(length = 50)
    private String contrasenia;
    @Column(length = 50)
    private String direccion;
    @Column(length = 13)
    private String tipoUsuario = "cliente";

}
