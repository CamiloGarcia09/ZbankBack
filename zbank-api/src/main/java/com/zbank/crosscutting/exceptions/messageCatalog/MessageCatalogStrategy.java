package com.zbank.crosscutting.exceptions.messageCatalog;

import com.zbank.crosscutting.exceptions.custom.CrosscuttingZBANKException;
import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.crosscutting.exceptions.messageCatalog.data.Mensaje;
import com.zbank.crosscutting.exceptions.messageCatalog.impl.MessageCatalogBase;
import com.zbank.crosscutting.exceptions.messageCatalog.impl.MessageCatalogExternalService;
import com.zbank.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogStrategy {

    private static final MessageCatalog base = new MessageCatalogBase();
    private static final MessageCatalog externalService = new MessageCatalogExternalService();

    static {
        inicializar();
    }

    private MessageCatalogStrategy() {
        super();
    }

    public static void inicializar() {
        base.inicializar();
        externalService.inicializar();
    }

    private static final MessageCatalog getStrategy(final boolean isBase) {
        return isBase ? base: externalService;
    }

    public static final Mensaje getMensaje(final CodigoMensaje codigo, final String...parametros){
        if (ObjectHelper.getObjectHelper().isNull(codigo)) {
            var mensajeUsuario = getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = getContenidoMensaje(CodigoMensaje.M00001);
            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
        }
        return getStrategy(codigo.isBase()).obtenerMensaje(codigo, parametros);
    }

    public static final String getContenidoMensaje(final CodigoMensaje codigo, final String...parametros) {
        return getMensaje(codigo, parametros).getContenido();
    }
}
