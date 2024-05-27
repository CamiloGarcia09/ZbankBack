package com.zbank.data.dao.entity.concrete.PostgreSql;

import com.zbank.crosscutting.exceptions.custom.DataZBANKException;
import com.zbank.crosscutting.helpers.ObjectHelper;
import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;
import com.zbank.data.dao.entity.TipoDocumentoDAO;
import com.zbank.data.dao.entity.concrete.SqlConnection;
import com.zbank.entity.DivisaEntity;
import com.zbank.entity.TipoDocumentoEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class TipoDocumentoSqlDAO extends SqlConnection implements TipoDocumentoDAO {

    public TipoDocumentoSqlDAO(final Connection conexion){
        super(conexion);
    }

    @Override
    public List<TipoDocumentoEntity> consultar(final TipoDocumentoEntity data) {
        final StringBuilder sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT id, nombre, abreviacion");
        sentenciaSql.append("FROM TipoDocumento");
        sentenciaSql.append("WHERE 1=1");

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
            for (int i=0; i < parametros.size(); i++){
                sentenciaSqlPreparada.setObject(i+1, parametros.get(i));
            }

            try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                    TipoDocumentoEntity tipoDocumento = TipoDocumentoEntity.build();
                    tipoDocumento.setId((UUID.fromString(resultado.getString("id"))));
                    tipoDocumento.setNombre(resultado.getString("nombreTipoDocumento"));
                    tipoDocumento.setAbreviacion(resultado.getString("abreviacionTipoDocumento"));

                    tipoDocumentos.add(tipoDocumento);
                }
            }

        }catch (final SQLException exception){
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar los tipos de documento. Por favor, contacte al administrador del sistema.";
            var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar la consulta de los tipos de documentos en la tabla \"TipoDocumento\" de la base de datos PostgreSQL.";

            throw new DataZBANKException(mensajeUsuario, mensajeTecnico, exception);

        } catch (final Exception exception){
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar los tipos de documento. Por favor, contacte al administrador del sistema.";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de los tipos de documentos en la tabla \"TipoDocumento\" de la base de datos PostgreSQL.";

            throw new DataZBANKException(mensajeUsuario, mensajeTecnico, exception);

        }

        return tipoDocumentos;
    }


    @Override
    public void modificar(TipoDocumentoEntity data) {

    }

}



