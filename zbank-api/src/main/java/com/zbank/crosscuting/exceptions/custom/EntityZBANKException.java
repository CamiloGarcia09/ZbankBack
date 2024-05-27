package com.zbank.crosscuting.exceptions.custom;

import com.zbank.crosscuting.exceptions.ZBANKException;
import com.zbank.crosscuting.exceptions.enums.Lugar;

public final class EntityZBANKException extends ZBANKException {

    private static final long serialVersionUID = 1L;

    public EntityZBANKException(final String mensajeUsuario) {
        super(mensajeUsuario, Lugar.ENTITY);
    }

    public EntityZBANKException(final String mensajeTecnico, final String mensajeUsuario) {
        super(mensajeTecnico, mensajeUsuario, Lugar.ENTITY);
    }
    public EntityZBANKException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
            super(mensajeTecnico, mensajeUsuario, Lugar.ENTITY, excepcionRaiz);
    }
}
