package com.zbank.crosscuting.exceptions.custom;

import com.zbank.crosscuting.exceptions.ZBANKException;
import com.zbank.crosscuting.exceptions.enums.Lugar;

public final class DataZBANKException extends ZBANKException {

    private static final long serialVersionUID = 1L;

    public DataZBANKException(final String mensajeUsuario) {
        super(mensajeUsuario, Lugar.DATA);
    }

    public DataZBANKException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
            super(mensajeTecnico, mensajeUsuario, Lugar.DATA, excepcionRaiz);
    }
}
