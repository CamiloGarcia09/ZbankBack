package com.zbank.data.dao.entity.concrete.PostgreSql;

import com.zbank.crosscutting.exceptions.custom.DataZBANKException;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.crosscutting.helpers.ObjectHelper;
import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;
import com.zbank.data.dao.entity.DivisaDAO;
import com.zbank.data.dao.entity.concrete.SqlConnection;
import com.zbank.entity.DivisaEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class DivisaPostgreSqlDAO extends SqlConnection implements DivisaDAO {

    private static final String CONSULTAR_DIVISA_SQL = "SELECT id, nombre, codigoISO FROM Divisa WHERE 1=1";

    public DivisaPostgreSqlDAO(final Connection conexion) {
        super(conexion);
    }

    @Override
    public List<DivisaEntity> consultar(final DivisaEntity data) {
        final StringBuilder sentenciaSql = new StringBuilder(CONSULTAR_DIVISA_SQL);
        final List<Object> parametros = new ArrayList<>();

        if (!ObjectHelper.getObjectHelper().isNull(data.getId()) && !data.getId().equals(UUIDHelper.getDefault())) {
            sentenciaSql.append(" AND id = ?");
            parametros.add(data.getId());
        }
        if (!TextHelper.isNullOrEmpty(data.getNombre())) {
            sentenciaSql.append(" AND nombre = ?");
            parametros.add(data.getNombre());
        }
        if (!TextHelper.isNullOrEmpty(data.getCodigoISO())) {
            sentenciaSql.append(" AND codigoISO = ?");
            parametros.add(data.getCodigoISO());
        }

        final List<DivisaEntity> divisas = new ArrayList<>();

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
            for (int i = 0; i < parametros.size(); i++) {
                sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
            }

            try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                    DivisaEntity divisa = DivisaEntity.build()
                            .setId(UUID.fromString(resultado.getString("id")))
                            .setNombre(resultado.getString("nombre"))
                            .setCodigoISO(resultado.getString("codigoISO"));

                    divisas.add(divisa);
                }
            }

        } catch (final SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00039);
            var mensajeTecnico =TextHelper.reemplazarParametro(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00040, data.getNombre()));

            throw new DataZBANKException(mensajeTecnico, mensajeUsuario, exception);

        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00041);
            var mensajeTecnico = TextHelper.reemplazarParametro(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00042), data.getNombre());

            throw new DataZBANKException(mensajeTecnico, mensajeUsuario, exception);
        }

        return divisas;
    }


    @Override
    public void modificar(DivisaEntity data) {

    }
}
