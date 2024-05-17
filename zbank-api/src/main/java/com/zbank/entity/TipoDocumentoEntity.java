package com.zbank.entity;

import org.hibernate.dialect.unique.CreateTableUniqueDelegate;

import java.util.UUID;

public class TipoDocumentoEntity {
    private UUID id;
    private String nombre;

    public TipoDocumentoEntity() {
        super();
    }
    public  TipoDocumentoEntity(UUID id, String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static final TipoDocumentoEntity build(){
        return new TipoDocumentoEntity();
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
}


