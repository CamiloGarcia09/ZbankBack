package com.zbank.data.dao.entity.concrete.PostgreSql;

import com.zbank.crosscutting.exceptions.custom.DataZBANKException;
import com.zbank.crosscutting.helpers.ObjectHelper;
import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;
import com.zbank.data.dao.entity.PerfilDAO;
import com.zbank.data.dao.entity.concrete.SqlConnection;
import com.zbank.entity.DivisaEntity;
import com.zbank.entity.PerfilEntity;
import com.zbank.entity.TipoDocumentoEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class PerfilPostgreSqlDAO extends SqlConnection implements PerfilDAO {

    public PerfilPostgreSqlDAO(final Connection conexion){
        super(conexion);
    }

    @Override
    public final void crear(PerfilEntity data) {
        final StringBuilder sentenciaSql = new StringBuilder ();

        sentenciaSql.append("INSERT INTO Perfil (id, nombre, apellido, tipoDocumento, numeroDocumento, divisa, nombreUsuario, clave, correo)");
        sentenciaSql.append("SELECT ?,?,?,?,?,?,?,?,?");

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())){

            sentenciaSqlPreparada.setObject(1, data.getId());
            sentenciaSqlPreparada.setString(2, data.getNombre());
            sentenciaSqlPreparada.setString(3, data.getApellido());
            sentenciaSqlPreparada.setObject(4, data.getTipoDocumento().getId());
            sentenciaSqlPreparada.setLong(5, data.getNumeroDocumento());
            sentenciaSqlPreparada.setObject(6, data.getDivisa().getId());
            sentenciaSqlPreparada.setString(7, data.getNombreUsuario());
            sentenciaSqlPreparada.setString(8, data.getClave());
            sentenciaSqlPreparada.setString(9, data.getCorreo());

            sentenciaSqlPreparada.executeUpdate();

        } catch (final SQLException excepcion) {
            var mensajeUsuario = "Se ha presentado un problema tratando de crear el perfil \"${1}\".Por favor intente de nuevo y si el problema persiste contacte con el administrador...";
            var mensajeTecnico = "Se ha presentado una excepcion de tipo SQLException tratando de realizar el insert deel perfil \"${1}\" en la tabla \"Perfil\" de la base de datos PostgreSQL. Para mas detalles, revise de forma completa la excepcion raiz presentada..";
            throw new DataZBANKException(mensajeTecnico, mensajeUsuario, excepcion);
        } catch (final Exception excepcion) {
            var mensajeUsuario = "Se ha presentado un problema tratando de crear el perfil \"${1}\".Por favor intente de nuevo y si el problema persiste contacte con el administrador...";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO de tipo Exception tratando de realizar el insert del perfil \"${1}\" en la tabla \"Perfil\" de la base de datos PostgreSQL. Para mas detalles, revise de forma completa la excepcion raiz presentada..";
            throw new DataZBANKException(mensajeTecnico, mensajeUsuario, excepcion);
        }
    }

    @Override
    public List<PerfilEntity> consultar(final PerfilEntity data) {
        final StringBuilder sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT p.id, p.nombre as nombre, p.apellido as apellido," +
                "t.id as idTipoDocumento, t.abreviacion as tipoDoumento, p.numeroDocumento as numeroDocumento, d.id as idDivisa, d.codigoISO as divisa, " +
                "p.nombreUsuario as nombreUsuario, p.clave as contraseña, p.correo as correoElectronico");

        sentenciaSql.append("FROM Perfil p");
        sentenciaSql.append("INNER JOIN Divisa d ON p.divisa = d.id");
        sentenciaSql.append("INNER JOIN TipoDocumento t on p.tipoDocumento = t.id");
        sentenciaSql.append("WHERE 1=1");

        final List<Object> parametros = new ArrayList<>();

        if (!ObjectHelper.getObjectHelper().isNull(data.getId()) && !data.getId().equals(UUIDHelper.getDefault())) {
            sentenciaSql.append(" AND p.id = ?");
            parametros.add(data.getId());
        }
        if (!TextHelper.isNullOrEmpty(data.getNombre())) {
            sentenciaSql.append(" AND p.nombre = ?");
            parametros.add(data.getNombre());
        }
        if (!TextHelper.isNullOrEmpty(data.getApellido())) {
            sentenciaSql.append(" AND p.apellido = ?");
            parametros.add(data.getNombre());
        }
        if (!ObjectHelper.getObjectHelper().isNull(data.getTipoDocumento()) &&
                !ObjectHelper.getObjectHelper().isNull(data.getTipoDocumento().getId()) &&
                !data.getTipoDocumento().getId().equals(UUIDHelper.getDefault())) {
            sentenciaSql.append(" AND p.tipoDocumento = ?");
            parametros.add(data.getTipoDocumento().getId());
        }
        sentenciaSql.append(" AND p.numeroDocumento = ?");
        parametros.add(data.getNumeroDocumento());
        if (!ObjectHelper.getObjectHelper().isNull(data.getDivisa()) &&
                !ObjectHelper.getObjectHelper().isNull(data.getDivisa().getId()) &&
                !data.getDivisa().getId().equals(UUIDHelper.getDefault())) {
            sentenciaSql.append(" AND p.divisa = ?");
            parametros.add(data.getDivisa().getId());
        }
        if (!TextHelper.isNullOrEmpty(data.getNombreUsuario())) {
            sentenciaSql.append(" AND p.nombreUsuario = ?");
            parametros.add(data.getNombreUsuario());
        }
        if (!TextHelper.isNullOrEmpty(data.getClave())) {
            sentenciaSql.append(" AND p.clave = ?");
            parametros.add(data.getClave());
        }
        if (!TextHelper.isNullOrEmpty(data.getCorreo())) {
            sentenciaSql.append(" AND p.correo = ?");
            parametros.add(data.getCorreo());
        }



        final List<PerfilEntity> perfiles = new ArrayList<>();

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
            for (int i=0; i < parametros.size(); i++){
                sentenciaSqlPreparada.setObject(i+1, parametros.get(i));
            }

            try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                    PerfilEntity perfil = PerfilEntity.build();
                    perfil.setId((UUID.fromString(resultado.getString("id"))));
                    perfil.setNombre(resultado.getString("nombre"));
                    perfil.setApellido(resultado.getString("apellido"));
                    perfil.setNumeroDocumento(resultado.getLong("numeroDocumento"));
                    perfil.setNombreUsuario(resultado.getString("nombreUsuario"));
                    perfil.setClave(resultado.getString("contraseña"));
                    perfil.setCorreo(resultado.getString("correoElectronio"));


                    TipoDocumentoEntity tipoDocumento = TipoDocumentoEntity.build();
                    tipoDocumento.setAbreviacion(resultado.getString("abreviacion"));

                    DivisaEntity divisa = DivisaEntity.build();
                    divisa.setCodigoISO(resultado.getString("codigoISO"));

                    perfil.setDivisa(divisa);
                    perfil.setTipoDocumento(tipoDocumento);

                    perfiles.add(perfil);
                }
            }

        }catch (final SQLException exception){
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar el perfil. Por favor, contacte al administrador del sistema.";
            var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar la consulta de los perfiles en la tabla \"Perfil\" de la base de datos PostgreSQL.";

            throw new DataZBANKException(mensajeUsuario, mensajeTecnico, exception);

        } catch (final Exception exception){
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar los perfiles. Por favor, contacte al administrador del sistema.";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de los perfiles en la tabla \"Perfil\" de la base de datos PostgreSQL.";

            throw new DataZBANKException(mensajeUsuario, mensajeTecnico, exception);

        }

        return perfiles;
    }

    @Override
    public void modificar(PerfilEntity data) {

    }

    @Override
    public void eliminar(PerfilEntity data) {

    }
}
