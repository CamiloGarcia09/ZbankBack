package com.zbank.crosscutting.exceptions.custom;

import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.crosscutting.exceptions.enums.Lugar;

public class DefaultZBANKException extends ZBANKException {
    private static final long serialVersionUID = -3662331984905572117L;
    private static final Lugar lugar=Lugar.DEFAULT;

    public DefaultZBANKException(final String mensajeUsuario , Lugar lugar) {
        super(mensajeUsuario, lugar);
    }
    public DefaultZBANKException(final String mensajeUsuario,final String mensajeTecnico) {
        super(mensajeTecnico, mensajeUsuario, lugar);
    }
    public DefaultZBANKException(final String mensajeTecnico,final String mensajeUsuario,
                               final Throwable exceptionRaiz) {
        super(mensajeTecnico,mensajeUsuario, lugar, exceptionRaiz);
    }
}
