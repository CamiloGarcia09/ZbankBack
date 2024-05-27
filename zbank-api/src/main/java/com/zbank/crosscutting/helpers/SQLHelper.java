package com.zbank.crosscutting.helpers;

import com.zbank.crosscutting.exceptions.custom.CrosscuttingZBANKException;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import java.sql.Connection;
import java.sql.SQLException;

public class SQLHelper {
    private SQLHelper() {
        super();
    }

    public static final boolean isNull(final Connection connection) {
        return ObjectHelper.getObjectHelper().isNull(connection);
    }

    public static final boolean isOpen(final Connection connection) {
        try {
            return !isNull(connection) && !connection.isClosed();
        } catch (final SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00007);

            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00008);

            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    public static final void close(final Connection connection) {
        try {
            if (!isOpen(connection)) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00009);

                throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
            }

            connection.close();
        } catch (final CrosscuttingZBANKException exception) {
            throw exception;
        } catch (final SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00010);

            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00011);

            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    public static final void commit(final Connection connection) {
        try {
            if (!isOpen(connection)) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00012);

                throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
            }

            if (connection.getAutoCommit()) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00013);

                throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
            }

            connection.commit();
        } catch (final CrosscuttingZBANKException exception) {
            throw exception;
        } catch (final SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00014);

            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00015);

            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    public static final void rollback(final Connection connection) {
        try {
            if (!isOpen(connection)) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00016);

                throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
            }

            if (connection.getAutoCommit()) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00017);

                throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
            }

            connection.rollback();
        } catch (final CrosscuttingZBANKException exception) {
            throw exception;
        } catch (final SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00018);

            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00019);

            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    public static final void initTransaction(final Connection connection) {
        try {
            if (!isOpen(connection)) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00020);

                throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
            }

            connection.setAutoCommit(false);
        } catch (final CrosscuttingZBANKException exception) {
            throw exception;
        } catch (final SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00021);

            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00022);

            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario, exception);
        }
    }
}
