package com.zbank.data.dao.entity.concrete.PostgreSql;

import com.zbank.crosscutting.exceptions.custom.DataZBANKException;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.crosscutting.helpers.ObjectHelper;
import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;
import com.zbank.data.dao.entity.TipoDocumentoDAO;
import com.zbank.data.dao.entity.concrete.SqlConnection;
import com.zbank.entity.TipoDocumentoEntity;
import org.springframework.context.support.MessageSourceAccessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class TipoDocumentoPostgreSqlDAO extends SqlConnection implements TipoDocumentoDAO {

    private static final String CONSULTAR_TIPOS_DOCUMENTO_SQL = "SELECT id, nombre, abreviacion FROM TipoDocumento WHERE 1=1";

    public TipoDocumentoPostgreSqlDAO(final Connection conexion) {
        super(conexion);
    }

    @Override
    public List<TipoDocumentoEntity> consultar(final TipoDocumentoEntity data) {

        final StringBuilder sentenciaSql = new StringBuilder(CONSULTAR_TIPOS_DOCUMENTO_SQL);
        final List<Object> parametros = new ArrayList<>();

        if (!ObjectHelper.getObjectHelper().isNull(data.getId()) && !data.getId().equals(UUIDHelper.getDefault())) {
            sentenciaSql.append(" AND id = ?");
            parametros.add(data.getId());
        }
        if (!TextHelper.isNullOrEmpty(data.getNombre())) {
            sentenciaSql.append(" AND nombre = ?");
            parametros.add(data.getNombre());
        }
        if (!TextHelper.isNullOrEmpty(data.getAbreviacion())) {
            sentenciaSql.append(" AND abreviacion = ?");
            parametros.add(data.getAbreviacion());
        }

        final List<TipoDocumentoEntity> tipoDocumentos = new ArrayList<>();

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
            for (int i = 0; i < parametros.size(); i++) {
                sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
            }

            try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                    TipoDocumentoEntity tipoDocumento = TipoDocumentoEntity.build()
                            .setId(UUID.fromString(resultado.getString("id")))
                            .setNombre(resultado.getString("nombre"))
                            .setAbreviacion(resultado.getString("abreviacion"));

                    tipoDocumentos.add(tipoDocumento);
                }
            }

        } catch (final SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00027);
            var mensajeTecnico = TextHelper.reemplazarParametro(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00028), data.getNombre());

            throw new DataZBANKException(mensajeTecnico, mensajeUsuario, exception);

        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00029);
            var mensajeTecnico = TextHelper.reemplazarParametro(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00030), data.getNombre());

            throw new DataZBANKException(mensajeTecnico, mensajeUsuario, exception);

        }

        return tipoDocumentos;
    }



@Override
    public void modificar(TipoDocumentoEntity data) {

    }

}



