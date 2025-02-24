package com.zbank.crosscutting.exceptions;

import com.zbank.crosscutting.exceptions.enums.Lugar;
import com.zbank.crosscutting.helpers.ObjectHelper;
import com.zbank.crosscutting.helpers.TextHelper;

public class ZBANKException extends RuntimeException{

    private static final long serialVersionUID=1L;
    protected String mensajeUsuario;
    protected Lugar lugar;

    public ZBANKException(final String mensajeTecnico,final String mensajeUsuario,
                        final Lugar lugar, final Throwable exceptionRaiz) {
        super(mensajeTecnico, exceptionRaiz);
        setMensajeUsuario(mensajeUsuario);
        setLugar(lugar);
    }

    public ZBANKException(final String mensajeTecnico, final String mensajeUsuario, final Lugar lugar ) {
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
        this.mensajeUsuario =TextHelper.applyTrim(mensajeUsuario);
    }

    private final void setLugar(final Lugar lugar) {
        this.lugar = ObjectHelper.getObjectHelper().getDefaultValue(lugar, Lugar.DEFAULT);

    }

    public final String getMensajeUsuario() {
        return mensajeUsuario;
    }

    public final Lugar getLugar() {
        return lugar;
    }
}
