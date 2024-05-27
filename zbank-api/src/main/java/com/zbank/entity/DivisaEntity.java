package com.zbank.entity;

import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public final class DivisaEntity {
    private UUID id;
    private String codigoISO;
    private String nombre;

    public DivisaEntity() {
        setId(UUIDHelper.getDefault());
        setCodigoISO(TextHelper.EMPTY);
        setNombre(TextHelper.EMPTY);
    }

    public DivisaEntity(final UUID id, final String codigoISO, final String nombre) {
        setId(id);
        setCodigoISO(codigoISO);
        setNombre(nombre);
    }

    public static final DivisaEntity build(){
        return new DivisaEntity();
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

    public final DivisaEntity setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public final DivisaEntity setCodigoISO(final String codigoISO) {
        this.codigoISO = TextHelper.applyTrim(codigoISO);
        return this;
    }

    public final DivisaEntity setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }
}

