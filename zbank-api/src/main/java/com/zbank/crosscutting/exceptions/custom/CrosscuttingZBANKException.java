package com.zbank.crosscutting.exceptions.custom;

import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.crosscutting.exceptions.enums.Lugar;

public final class CrosscuttingZBANKException extends ZBANKException {

    private static final long serialVersionUID = 1L;
    private static final Lugar lugar=Lugar.CROSSCUTTING;

    public CrosscuttingZBANKException(final String mensajeUsuario) {
        super(mensajeUsuario, lugar);
    }

    public CrosscuttingZBANKException(final String mensajeTecnico,final String mensajeUsuario) {
        super(mensajeTecnico,mensajeUsuario,lugar);
    }

    public CrosscuttingZBANKException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
        super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
    }
}
