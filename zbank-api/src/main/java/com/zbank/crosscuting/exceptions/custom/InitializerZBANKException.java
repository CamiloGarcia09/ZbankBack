package com.zbank.crosscuting.exceptions.custom;

import com.zbank.crosscuting.exceptions.ZBANKException;
import com.zbank.crosscuting.exceptions.enums.Lugar;

public final class InitializerZBANKException extends ZBANKException {

    private static final long serialVersionUID = 1L;

    public InitializerZBANKException(final String mensajeUsuario) {
        super(mensajeUsuario, Lugar.INITIALIZER);
    }

    public InitializerZBANKException(final String mensajeTecnico, final String mensajeUsuario) {
        super(mensajeTecnico, mensajeUsuario, Lugar.INITIALIZER);
    }

    public InitializerZBANKException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
        super(mensajeTecnico, mensajeUsuario, Lugar.INITIALIZER, excepcionRaiz);
    }
}
