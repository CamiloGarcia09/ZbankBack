package com.zbank.crosscuting.exceptions.messageCatalog.impl;

import com.zbank.crosscuting.exceptions.custom.CrosscuttingZBANKException;
import com.zbank.crosscuting.exceptions.messageCatalog.MessageCatalog;
import com.zbank.crosscuting.exceptions.messageCatalog.MessageCatalogStrategy;
import com.zbank.crosscuting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.crosscuting.exceptions.messageCatalog.data.Mensaje;
import com.zbank.crosscuting.helpers.ObjectHelper;

import java.util.HashMap;
import java.util.Map;

public class MessageCatalogExternalService implements MessageCatalog {
    private final Map<String, Mensaje> mensajes=new HashMap<>();

    @Override
    public void inicializar() {
        mensajes.clear();
        mensajes.put(CodigoMensaje.M00007.getIdentificador(),new Mensaje(CodigoMensaje.M00007,
                "La transacción se ha completado satisfactoriamente"));
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
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00005,codigo.getIdentificador());
            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
        }
        if(!mensajes.containsKey(codigo.getIdentificador())) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00006,codigo.getIdentificador());
            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
        }
        return mensajes.get(codigo.getIdentificador());
    }
}
