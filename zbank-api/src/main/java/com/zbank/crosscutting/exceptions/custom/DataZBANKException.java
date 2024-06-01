package com.zbank.crosscutting.exceptions.custom;

import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.crosscutting.exceptions.enums.Lugar;

public final class DataZBANKException extends ZBANKException {

    private static final long serialVersionUID = 1L;
    private static final Lugar lugar = Lugar.DATA;

    public DataZBANKException(final String mensajeUsuario) {
        super(mensajeUsuario, lugar);
    }

    public DataZBANKException(final String mensajeUsuario,final String mensajeTecnico) {
        super(mensajeTecnico, mensajeUsuario, lugar);
    }

    public DataZBANKException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
        super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
    }
}
