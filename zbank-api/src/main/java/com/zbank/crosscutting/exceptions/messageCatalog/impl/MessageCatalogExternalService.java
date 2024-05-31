package com.zbank.crosscutting.exceptions.messageCatalog.impl;

import com.zbank.crosscutting.exceptions.custom.CrosscuttingZBANKException;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalog;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.crosscutting.exceptions.messageCatalog.data.Mensaje;
import com.zbank.crosscutting.helpers.ObjectHelper;
import com.zbank.crosscutting.helpers.TextHelper;

import java.util.HashMap;
import java.util.Map;

public class MessageCatalogExternalService implements MessageCatalog {
    private final Map<String, Mensaje> mensajes=new HashMap<>();

    @Override
    public void inicializar() {

        mensajes.clear();
        mensajes.put(CodigoMensaje.M00024.getIdentificador(), new Mensaje(CodigoMensaje.M00024,
                "Se ha presentado un problema tratando de obtener la conexión con la base de datos PostgreSQL. Por favor revise la traza de errores para identificar y solucionar el problema..."));

        mensajes.put(CodigoMensaje.M00025.getIdentificador(), new Mensaje(CodigoMensaje.M00025,
                "Se ha presentado un problema INESPERADO tratando de obtener la conexión con la base de datos PostgreSQL. Por favor revise la traza de errores para identificar y solucionar el problema..."));


    }

    @Override
    public String obtenerContendidoMensaje(CodigoMensaje codigo, String... parametros) {
        return obtenerMensaje(codigo,parametros).getContenido();
    }

    @Override
    public Mensaje obtenerMensaje(CodigoMensaje codigo, String... parametros) {
        if(ObjectHelper.getObjectHelper().isNull(codigo)){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico =  MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
        }
        if(codigo.isBase()) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = TextHelper.reemplazarParametro(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00005,codigo.getIdentificador()));
            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
        }
        if(!mensajes.containsKey(codigo.getIdentificador())) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = TextHelper.reemplazarParametro(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00006,codigo.getIdentificador()));
            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
        }
        return mensajes.get(codigo.getIdentificador());
    }
}
