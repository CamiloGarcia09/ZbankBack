package com.zbank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "perfiles")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "nombre")
    private String nombre;

    @Column(name= "apellido")
    private String apellido;

    @Column(name= "correo")
    private String correo;

    @Column(name= "divisa")
    private String divisa;

    @Column(name= "tipoDivisa")
    private String tipoDivisa;

    @Column(name= "numeroDocumento")
    private long numeroDocumento;

    @Column(name= "nombreUsuario")
    private String nombreUsuario;

    @Column(name= "calve")
    private String clave;
}
