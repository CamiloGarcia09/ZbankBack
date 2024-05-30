package com.zbank.data.dao.factory;

import com.zbank.data.dao.entity.DivisaDAO;
import com.zbank.data.dao.entity.PerfilDAO;
import com.zbank.data.dao.entity.TipoDocumentoDAO;
import com.zbank.data.dao.factory.concrete.PostgreSQLDAOFactory;

public interface DAOFactory {
    static DAOFactory getFactory() {
        return new PostgreSQLDAOFactory();
    }

    void cerrarConexion();

    void iniciarTransaccion();

    void confirmarTransaccion();

    void cancelarTransaccion();

    PerfilDAO getPerfilDAO();

    TipoDocumentoDAO getTipoDocumentoDAO();

    DivisaDAO getDivisaDAO();
}
