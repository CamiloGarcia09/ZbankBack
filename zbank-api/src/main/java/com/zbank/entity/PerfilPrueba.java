package com.zbank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Perfiles")
public class PerfilPrueba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "correo")
    private String correo;

    @Column(name = "divisa")
    private String divisa;

    @Column(name = "numeroDocumento")
    private long numeroDocumento;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "clave")
    private String clave;
}
