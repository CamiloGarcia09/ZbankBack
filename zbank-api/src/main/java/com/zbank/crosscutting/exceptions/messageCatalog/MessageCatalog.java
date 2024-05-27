package com.zbank.crosscutting.exceptions.messageCatalog;

import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.crosscutting.exceptions.messageCatalog.data.Mensaje;

public interface MessageCatalog {
    void  inicializar();

    String obtenerContendidoMensaje(final CodigoMensaje codigo , String...parametros);
    Mensaje obtenerMensaje(final CodigoMensaje codigo, String...parametros);
}

