package com.zbank.entity;

import java.util.UUID;

public class DivisaEntity {
    private UUID id;
    private String codigoISO;
    private String nombre;

    public DivisaEntity() {
        super();
    }

    public DivisaEntity(UUID id, String codigoISO, String nombre) {
        setId(id);
        setCodigoISO(codigoISO);
        setNombre(nombre);

    }

    public static final DivisaEntity buid(){
        return new DivisaEntity();
    }

    public final UUID getId() {
        return id;
    }

    public final void setId(final UUID id) {
        this.id = id;
    }

    public final String getCodigoISO() {
        return codigoISO;
    }

    public final void setCodigoISO(final String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public final String getNombre() {
        return nombre;
    }

    public final void setNombre(final String nombre) {
        this.nombre = nombre;
    }
}

