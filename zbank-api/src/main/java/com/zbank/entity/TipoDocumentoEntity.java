package com.zbank.entity;

import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public final class TipoDocumentoEntity {

    private UUID id;
    private String nombre;
    private String abreviacion;

    public TipoDocumentoEntity() {
        setId(UUIDHelper.getDefault());
        setNombre(TextHelper.EMPTY);
        setAbreviacion(TextHelper.EMPTY);
    }

    public TipoDocumentoEntity(final UUID id, final String nombre, final String abreviacion) {
        setId(id);
        setNombre(nombre);
        setAbreviacion(abreviacion);
    }

    public static final TipoDocumentoEntity build(){
        return new TipoDocumentoEntity();
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

    public final TipoDocumentoEntity setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public final TipoDocumentoEntity setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }

    public final TipoDocumentoEntity setAbreviacion(final String abreviacion) {
        this.abreviacion = TextHelper.applyTrim(abreviacion);
        return this;
    }
}