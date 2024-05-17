package com.zbank.crosscuting.exceptions.custom;

import com.zbank.crosscuting.exceptions.ZBANKException;
import com.zbank.crosscuting.exceptions.enums.Lugar;

public final class CrosscutingZBANKException extends ZBANKException {

    private static final long serialVersionUID = 1L;

    public CrosscutingZBANKException(final String mensajeUsuario) {
        super(mensajeUsuario, Lugar.CROSSCUTTING);
    }

    public CrosscutingZBANKException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
        super(mensajeTecnico, mensajeUsuario, Lugar.CROSSCUTTING, excepcionRaiz);
    }
}
