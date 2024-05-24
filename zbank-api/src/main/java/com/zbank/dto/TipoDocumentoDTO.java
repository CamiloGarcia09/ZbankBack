package com.zbank.dto;

import java.util.UUID;

public class TipoDocumentoDTO {
    private UUID id;
    private String nombre;

    public TipoDocumentoDTO() {
        super();
    }
    public TipoDocumentoDTO(UUID id, String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static final TipoDocumentoDTO build(){
        return new TipoDocumentoDTO();
    }

    public final UUID getId() {
        return id;
    }

    public final TipoDocumentoDTO setId(final UUID id) {
        this.id = id;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final TipoDocumentoDTO setNombre(final String nombre) {
        this.nombre = nombre;
        return this;
    }
}


