package com.zbank.crosscuting.exceptions;

import com.zbank.crosscuting.exceptions.enums.Lugar;
import com.zbank.crosscuting.helpers.ObjectHelper;
import com.zbank.crosscuting.helpers.TextHelper;

public class ZBANKException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    protected String mensajeUsuario;
    protected Lugar lugar;

    public ZBANKException(final String mensajeTecnico, final String mensajeUsuario, final Lugar lugar, final Throwable excepcionRaiz) {
        super(mensajeTecnico, excepcionRaiz);
        setMensajeUsuario(mensajeUsuario);
        setLugar(lugar);
    }

    public ZBANKException(final String mensajeTecnico, final String mensajeUsuario, final Lugar lugar) {
        super(mensajeTecnico);
        setMensajeUsuario(mensajeUsuario);
        setLugar(lugar);
    }

    public ZBANKException(final String mensajeUsuario, final Lugar lugar) {
        super(mensajeUsuario);
        setMensajeUsuario(mensajeUsuario);
        setLugar(lugar);
    }

    private final void setMensajeUsuario(final String mensajeUsuario) {
        this.mensajeUsuario = TextHelper.applyTrim(mensajeUsuario);
    }

    private final void setLugar(final Lugar lugar) {
        this.lugar = ObjectHelper.getObjectHelper().getDefaultValue(lugar, Lugar.DEFAULT);
    }

    public String getMensajeUsuario() {
        return mensajeUsuario;
    }

    public Lugar getLugar() {
        return lugar;
    }
}
