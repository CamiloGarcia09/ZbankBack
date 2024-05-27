package com.zbank.crosscutting.exceptions.custom;

import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.crosscutting.exceptions.enums.Lugar;

public final class ControllerZBANKException extends ZBANKException {

    private static final long serialVersionUID = 1L;

    public ControllerZBANKException(final String mensajeUsuario) {
        super(mensajeUsuario, Lugar.CONTROLLER);
    }
    public ControllerZBANKException(final String mensajeTecnico, final String mensajeUsuario) {
        super(mensajeTecnico, mensajeUsuario, Lugar.CONTROLLER);
    }

    public ControllerZBANKException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
        super(mensajeTecnico, mensajeUsuario, Lugar.CONTROLLER, excepcionRaiz);
    }
}
