package com.zbank.business.domain;

import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public final class DivisaDomain {

    private UUID id;
    private String codigoISO;
    private String nombre;

    public DivisaDomain( final UUID id, final String codigoISO,final String nombre) {
        setId(id);
        setCodigoISO(codigoISO);
        setNombre(nombre);
    }

    public static final DivisaDomain build(final UUID id,final String codigoISO, final String nombre) {
       return new DivisaDomain(id, codigoISO, nombre);
    }

    public static final DivisaDomain build (final UUID id) {
        return new DivisaDomain(id, TextHelper.EMPTY,TextHelper.EMPTY);
    }

    public static final DivisaDomain build(){
        return new DivisaDomain(UUIDHelper.getDefault(), TextHelper.EMPTY,TextHelper.EMPTY);
    }

    public UUID getId() {
        return id;
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public String getNombre() {
        return nombre;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    private void setCodigoISO(final String codigoISO) {
        this.codigoISO = TextHelper.applyTrim(codigoISO);
    }

    private void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }
}
