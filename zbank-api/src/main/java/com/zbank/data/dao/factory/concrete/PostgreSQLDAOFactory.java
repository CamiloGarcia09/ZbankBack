package com.zbank.data.dao.factory.concrete;

import com.zbank.crosscutting.exceptions.custom.DataZBANKException;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.crosscutting.helpers.SQLHelper;
import com.zbank.data.dao.entity.DivisaDAO;
import com.zbank.data.dao.entity.PerfilDAO;
import com.zbank.data.dao.entity.TipoDocumentoDAO;
import com.zbank.data.dao.entity.concrete.PostgreSql.DivisaPostgreSqlDAO;
import com.zbank.data.dao.entity.concrete.PostgreSql.PerfilPostgreSqlDAO;
import com.zbank.data.dao.entity.concrete.PostgreSql.TipoDocumentoPostgreSqlDAO;
import com.zbank.data.dao.entity.concrete.SqlConnection;
import com.zbank.data.dao.factory.DAOFactory;
import org.springframework.beans.factory.annotation.Value;

import java.sql.DriverManager;
import java.sql.SQLException;

public final class PostgreSQLDAOFactory extends SqlConnection implements DAOFactory {

    public PostgreSQLDAOFactory() {
        super();
        abrirConexion();
    }

    private void abrirConexion() {
        final String connectionUrl = "jdbc:postgresql://localhost:5432/Zbanky?user=postgres&password=1040";
        try {
            setConexion(DriverManager.getConnection(connectionUrl));
        } catch (final SQLException excepcion) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00024);

            throw new DataZBANKException(mensajeTecnico, mensajeUsuario, excepcion);
        } catch (final Exception excepcion) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00025);

            throw new DataZBANKException(mensajeTecnico, mensajeUsuario, excepcion);
        }
    }


    @Override
    public void cerrarConexion() {
        SQLHelper.close(getConexion());
    }

    @Override
    public void iniciarTransaccion() {
        SQLHelper.initTransaction(getConexion());
    }

    @Override
    public void confirmarTransaccion() {
        SQLHelper.commit(getConexion());
    }

    @Override
    public void cancelarTransaccion() {
        SQLHelper.rollback(getConexion());
    }

    @Override
    public PerfilDAO getPerfilDAO() {
        return new PerfilPostgreSqlDAO(getConexion());
    }

    @Override
    public TipoDocumentoDAO getTipoDocumentoDAO() {
        return new TipoDocumentoPostgreSqlDAO(getConexion());
    }

    @Override
    public DivisaDAO getDivisaDAO() {
        return new DivisaPostgreSqlDAO(getConexion());
    }

}
