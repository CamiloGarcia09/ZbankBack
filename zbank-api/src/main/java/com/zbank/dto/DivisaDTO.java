package com.zbank.dto;

import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public final class DivisaDTO {
    private UUID id;
    private String codigoISO;
    private String nombre;

    public DivisaDTO() {
        setId(UUIDHelper.getDefault());
        setCodigoISO(TextHelper.EMPTY);
        setNombre(TextHelper.EMPTY);
    }

    public DivisaDTO(final UUID id, final String codigoISO, final String nombre) {
        setId(id);
        setCodigoISO(codigoISO);
        setNombre(nombre);
    }

    public static final DivisaDTO build(){
        return new DivisaDTO();
    }

    public final UUID getId() {
        return id;
    }

    public final String getCodigoISO() {
        return codigoISO;
    }

    public final String getNombre() {
        return nombre;
    }

    public final DivisaDTO setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public final DivisaDTO setCodigoISO(final String codigoISO) {
        this.codigoISO = TextHelper.applyTrim(codigoISO);
        return this;
    }

    public final DivisaDTO setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }
}

