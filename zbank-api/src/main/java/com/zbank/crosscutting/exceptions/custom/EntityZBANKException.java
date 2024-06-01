package com.zbank.crosscutting.exceptions.custom;

import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.crosscutting.exceptions.enums.Lugar;

public final class EntityZBANKException extends ZBANKException {

    private static final long serialVersionUID = 1L;
    private static final Lugar lugar = Lugar.ENTITY;

    public EntityZBANKException(final String mensajeUsuario) {
        super(mensajeUsuario, lugar);
    }

    public EntityZBANKException(final String mensajeTecnico, final String mensajeUsuario) {
        super(mensajeTecnico, mensajeUsuario, lugar);
    }

    public EntityZBANKException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
        super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
    }
}
