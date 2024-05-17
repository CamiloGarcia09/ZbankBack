package com.zbank.crosscuting.exceptions.custom;

import com.zbank.crosscuting.exceptions.ZBANKException;
import com.zbank.crosscuting.exceptions.enums.Lugar;

public final class BusinessZBANKException  extends ZBANKException {

    private static final long serialVersionUID = 1L;

    public BusinessZBANKException(final String mensajeUsuario) {
        super(mensajeUsuario, Lugar.BUSINESS);
    }

    public BusinessZBANKException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
        super(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS, excepcionRaiz);
    }
}
