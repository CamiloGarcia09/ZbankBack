package com.zbank.entity;

import java.util.UUID;

public class PerfilEntity {
    private UUID id;
    private String nombre;
    private String apellido;
    private  TipoDocumentoEntity tipoDocumento;
    private long numeroDocumento;
    private DivisaEntity divisa;
    private String nombreUsuario;
    private String correo;

    public PerfilEntity() {
        super();
    }

    public final UUID getId() {
        return id;
    }

    public final void setId(final UUID id) {
        this.id = id;
    }

    public final String getNombre() {
        return nombre;
    }

    public final void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public final String getApellido() {
        return apellido;
    }

    public final void setApellido(final String apellido) {
        this.apellido = apellido;
    }

    public final TipoDocumentoEntity getTipoDocumento() {
        return tipoDocumento;
    }

    public final void setTipoDocumento(final TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public final long getNumeroDocumento() {
        return numeroDocumento;
    }

    public final void setNumeroDocumento(final long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public final DivisaEntity getDivisa() {
        return divisa;
    }

    public final void setDivisa(final DivisaEntity divisa) {
        this.divisa = divisa;
    }

    public final String getNombreUsuario() {
        return nombreUsuario;
    }

    public final void setNombreUsuario(final String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public final String getCorreo() {
        return correo;
    }

    public final void setCorreo(final String correo) {
        this.correo = correo;
    }
}
