package com.zbank.data.dao.entity.concrete;

import com.zbank.crosscutting.exceptions.custom.DataZBANKException;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.crosscutting.helpers.SQLHelper;

import java.sql.Connection;

public class SqlConnection {

    private Connection conexion;

    protected SqlConnection() {
        super();
    }

    protected SqlConnection(final Connection conexion) {
        setConexion(conexion);
    }

    protected final Connection getConexion() {
        return conexion;
    }

    protected final void setConexion(final Connection conexion) {
        if (!SQLHelper.isOpen(conexion)) {
            var mensajeUsuario= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico="No es posible crear el DAO deseado con una conexión cerrada";

            throw new DataZBANKException(mensajeTecnico,mensajeUsuario);
        }
        this.conexion = conexion;
    }
}
