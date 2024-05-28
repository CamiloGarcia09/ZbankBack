package com.zbank.business.domain;

import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public final class TipoDocumentoDomain {

    private UUID id;
    private String nombre;
    private String abreviacion;

    private TipoDocumentoDomain(final UUID id, final String nombre,final String abreviacion) {
        setId(id);
        setNombre(nombre);
        setAbreviacion(abreviacion);
    }

    public static final TipoDocumentoDomain build(final UUID id,final String nombre, final String abreviacion){
        return new TipoDocumentoDomain(id,TextHelper.EMPTY,TextHelper.EMPTY);
    }

    public static final TipoDocumentoDomain build(final UUID id){
        return new TipoDocumentoDomain(id,TextHelper.EMPTY,TextHelper.EMPTY);
    }

    public static final TipoDocumentoDomain build(){
        return new TipoDocumentoDomain(UUIDHelper.getDefault(), TextHelper.EMPTY,TextHelper.EMPTY);
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    private void setId(UUID id) {
        this.id =  UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    private void setNombre(String nombre) {
        this.nombre =  TextHelper.applyTrim(nombre);
    }

    private void setAbreviacion(String abreviacion) {
        this.abreviacion = TextHelper.applyTrim(abreviacion);
    }
}
