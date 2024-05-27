package com.zbank.crosscutting.exceptions.custom;

import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.crosscutting.exceptions.enums.Lugar;

public final class BusinessZBANKException  extends ZBANKException {

    private static final long serialVersionUID = 1L;
    private static final Lugar lugar = Lugar.BUSINESS;

    public BusinessZBANKException(final String mensajeUsuario) {
        super(mensajeUsuario, lugar);
    }
    public BusinessZBANKException(final String mensajeTecnico, final String mensajeUsuario) {
        super(mensajeTecnico, mensajeUsuario, lugar);
    }
    public BusinessZBANKException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
        super(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS, excepcionRaiz);
    }
}
