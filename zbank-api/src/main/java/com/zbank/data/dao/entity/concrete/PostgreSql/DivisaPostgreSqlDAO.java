package com.zbank.data.dao.entity.concrete.PostgreSql;

import com.zbank.crosscutting.exceptions.custom.DataZBANKException;
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

    public DivisaPostgreSqlDAO(final Connection conexion) {
        super(conexion);
    }

    @Override
    public List<DivisaEntity> consultar(final DivisaEntity data) {
        final StringBuilder sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT id, nombre, codigoISO");
        sentenciaSql.append("FROM Divisa");
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
        if (!TextHelper.isNullOrEmpty(data.getCodigoISO())) {
            sentenciaSql.append(" AND codigoISO = ?");
            parametros.add(data.getCodigoISO());
        }


        final List<DivisaEntity> divisas = new ArrayList<>();

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
            for (int i=0; i < parametros.size(); i++){
                sentenciaSqlPreparada.setObject(i+1, parametros.get(i));
            }

            try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                    DivisaEntity divisa = DivisaEntity.build();
                    divisa.setId((UUID.fromString(resultado.getString("id"))));
                    divisa.setNombre(resultado.getString("nombreDivisa"));
                    divisa.setCodigoISO(resultado.getString("codigoISO"));

                    divisas.add(divisa);
                }
            }

        }catch (final SQLException exception){
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las divisas. Por favor, contacte al administrador del sistema.";
            var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar la consulta de las divisas en la tabla \"Divisa\" de la base de datos PostgreSQL.";

            throw new DataZBANKException(mensajeUsuario, mensajeTecnico, exception);

        } catch (final Exception exception){
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las divisas. Por favor, contacte al administrador del sistema.";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de las divisas en la tabla \"Divisa\" de la base de datos PostgreSQL.";

            throw new DataZBANKException(mensajeUsuario, mensajeTecnico, exception);

        }

        return divisas;
    }



    @Override
    public void modificar(DivisaEntity data) {

    }
}
