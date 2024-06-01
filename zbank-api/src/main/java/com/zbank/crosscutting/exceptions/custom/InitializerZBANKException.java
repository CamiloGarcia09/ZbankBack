package com.zbank.crosscutting.exceptions.custom;

import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.crosscutting.exceptions.enums.Lugar;

public final class InitializerZBANKException extends ZBANKException {

    private static final long serialVersionUID = 1L;
    private static final Lugar lugar = Lugar.INITIALIZER;

    public InitializerZBANKException(final String mensajeUsuario) {
        super(mensajeUsuario, lugar);
    }

    public InitializerZBANKException(final String mensajeTecnico, final String mensajeUsuario) {
        super(mensajeTecnico, mensajeUsuario, lugar);
    }

    public InitializerZBANKException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
        super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
    }
}
