package com.zbank.data.dao.factory.concrete;

import com.zbank.crosscutting.exceptions.ZBANKException;
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
import java.sql.DriverManager;
import java.sql.SQLException;

public final class PostgreSQLDAOFactory extends SqlConnection implements DAOFactory {

    public PostgreSQLDAOFactory() {
        super();
        abrirConexion();
    }

    private void abrirConexion() {
        final String connectionUrl = "jdbc:postgresql://localhost:5432/Zbanky?user=postgres&password=653200";  //URL de la base de datos, usuario y contraseña para acceder a ella
        try {
            setConexion(DriverManager.getConnection(connectionUrl));
        } catch (final ZBANKException excepcion) {
            throw excepcion;
        } catch (final SQLException excepcion) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = "Se ha presentado un problema trat  ando de obtener la conexión con la base de datos ZBANK en el servidor de bases de datos..... Por favor revise la traza de errores para identificar y solucionar el problema...";

            throw new DataZBANKException(mensajeTecnico, mensajeUsuario, excepcion);
        } catch (final Exception excepcion) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de obtener la conexión con la base de datos ZBANK en el servidor de bases de datos..... Por favor revise la traza de errores para identificar y solucionar el problema...";

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

   /* public static void main(String[] args) {
		try {
			DAOFactory factory = DAOFactory.getFactory();

			System.out.println("Iniciando transacción...");
			factory.iniciarTransaccion();

			System.out.println("Creando ciudad aleatoriamente");
			DepartamentoEntity departamento = DepartamentoEntity.build()
					.setId(UUIDHelper.convertToUUID("7827155D-0A6B-4D6E-9807-C5B7097D94F0"));
			CiudadEntity ciudad = CiudadEntity.build().setId(UUIDHelper.generate())
					.setNombre("Rionegro-" + UUIDHelper.generate()).setDepartamento(departamento);

			factory.getCiudadDAO().crear(ciudad);

			System.out.println("Consultamos ciudades: ");
			var resultados = factory.getCiudadDAO().consultar(CiudadEntity.build());

			for (CiudadEntity ciudadEntity : resultados) {
				System.out.println("idCiudad: " + ciudadEntity.getId() + ", nombreCiudad: " + ciudadEntity.getNombre()
						+ ", idDepartamento: " + ciudadEntity.getDepartamento().getId() + ", nombreDepartamento: "
						+ ciudadEntity.getDepartamento().getNombre() + ", idPais: "
						+ ciudadEntity.getDepartamento().getPais().getId() + ", nombrePais: "
						+ ciudadEntity.getDepartamento().getPais().getNombre());
			}

			System.out.println("Confirmando transacción...");
			factory.confirmarTransaccion();
			System.out.println("Cerrando conexión...");
			factory.cerrarConexion();
		} catch (final Exception excepcion) {
			excepcion.printStackTrace();
		}
	}*/
}
