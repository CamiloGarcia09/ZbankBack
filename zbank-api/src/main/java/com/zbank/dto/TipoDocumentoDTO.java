package com.zbank.dto;

import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public final class TipoDocumentoDTO {

    private UUID id;
    private String nombre;
    private String abreviacion;

    public TipoDocumentoDTO() {
        super();
        setId(UUIDHelper.getDefault());
        setNombre(TextHelper.EMPTY);
        setAbreviacion(TextHelper.EMPTY);
    }

    public TipoDocumentoDTO(final UUID id, final String nombre, final String abreviacion) {
        setId(id);
        setNombre(nombre);
        setAbreviacion(abreviacion);
    }

    public static final TipoDocumentoDTO build(){
        return new TipoDocumentoDTO();
    }

//Este fue el agregado
    public static TipoDocumentoDTO fromString(String value) {
        UUID id = UUID.fromString(value);
        return new TipoDocumentoDTO(id, TextHelper.EMPTY, TextHelper.EMPTY);
    }

    public final UUID getId() {
        return id;
    }

    public final String getAbreviacion() {
        return abreviacion;
    }

    public final String getNombre() {
        return nombre;
    }

    public final TipoDocumentoDTO setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public final TipoDocumentoDTO setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }

    public final TipoDocumentoDTO setAbreviacion(final String abreviacion) {
        this.abreviacion = TextHelper.applyTrim(abreviacion);
        return this;
    }
}


