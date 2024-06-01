package com.zbank.crosscutting.exceptions.messageCatalog.impl;

import com.zbank.crosscutting.exceptions.custom.CrosscuttingZBANKException;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalog;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.crosscutting.exceptions.messageCatalog.data.Mensaje;
import com.zbank.crosscutting.helpers.ObjectHelper;
import com.zbank.crosscutting.helpers.TextHelper;

import java.util.HashMap;
import java.util.Map;

public class MessageCatalogExternalService implements MessageCatalog {
    private final Map<String, Mensaje> mensajes=new HashMap<>();

    @Override
    public void inicializar() {

        mensajes.clear();


        mensajes.put(CodigoMensaje.M00024.getIdentificador(), new Mensaje(CodigoMensaje.M00024,
                "Se ha presentado un problema tratando de obtener la conexión con la base de datos PostgreSQL. Por favor revise la traza de errores para identificar y solucionar el problema..."));

        mensajes.put(CodigoMensaje.M00025.getIdentificador(), new Mensaje(CodigoMensaje.M00025,
                "Se ha presentado un problema INESPERADO tratando de obtener la conexión con la base de datos PostgreSQL. Por favor revise la traza de errores para identificar y solucionar el problema..."));

        mensajes.put((CodigoMensaje.M00026.getIdentificador()), new Mensaje(CodigoMensaje.M00026,
                "No es posible crear el DAO deseado con una conexión cerrada..."));

        mensajes.put((CodigoMensaje.M00027.getIdentificador()),new Mensaje(CodigoMensaje.M00027,
                "Se ha presentado un problema tratando de consultar los tipos de documento. Por favor, contacte al administrador del sistema."));

        mensajes.put((CodigoMensaje.M00028.getIdentificador()), new Mensaje(CodigoMensaje.M00028,
                "Se ha presentado una SQLException tratando de realizar la consulta de los tipos de documentos en la tabla \"TipoDocumento\" de la base de datos PostgreSQL."));

        mensajes.put((CodigoMensaje.M00029.getIdentificador()), new Mensaje(CodigoMensaje.M00029,
                "Se ha presentado un problema tratando de consultar los tipos de documento. Por favor, contacte al administrador del sistema."));

        mensajes.put((CodigoMensaje.M00030.getIdentificador()), new Mensaje(CodigoMensaje.M00030,
                "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de los tipos de documentos en la tabla \"TipoDocumento\" de la base de datos PostgreSQL."));

        mensajes.put((CodigoMensaje.M00031.getIdentificador()),new Mensaje(CodigoMensaje.M00031,
                "Se ha presentado un problema tratando de crear el perfil \"%s\". Por favor intente de nuevo y si el problema persiste contacte con el administrador..."));

        mensajes.put((CodigoMensaje.M00032.getIdentificador()), new Mensaje(CodigoMensaje.M00032,"Se ha presentado una excepcion de tipo SQLException tratando de realizar el insert del perfil \"%s\" en la tabla \"Perfil\" de la base de datos " +
                "PostgreSQL. Para más detalles, revise de forma completa la excepción raíz presentada.."));

        mensajes.put((CodigoMensaje.M00033.getIdentificador()), new Mensaje(CodigoMensaje.M00033,
                "Se ha presentado un problema tratando de registrar el perfil \"%s\". Por favor intente de nuevo y si el problema persiste contacte con el administrador..."));

        mensajes.put((CodigoMensaje.M00034.getIdentificador()), new Mensaje(CodigoMensaje.M00034,
                "Se ha presentado un problema INESPERADO de tipo Exception tratando de realizar el insert del perfil \"%s\" en la tabla \"Perfil\" de la base de datos PostgreSQL. Para más detalles, revise de forma completa la excepción raíz presentada.."));

        mensajes.put((CodigoMensaje.M00035.getIdentificador()),new Mensaje(CodigoMensaje.M00035,
                "Se ha presentado un problema tratando de consultar el perfil. Por favor, contacte al administrador del sistema."));

        mensajes.put((CodigoMensaje.M00036.getIdentificador()),new Mensaje(CodigoMensaje.M00036,
                "Se ha presentado una SQLException tratando de realizar la consulta de los perfiles en la tabla \"Perfil\" de la base de datos PostgreSQL."));

        mensajes.put((CodigoMensaje.M00037.getIdentificador()), new Mensaje(CodigoMensaje.M00037,
                "Se ha presentado un problema tratando de consultar los perfiles. Por favor, contacte al administrador del sistema."));

        mensajes.put((CodigoMensaje.M00038.getIdentificador()), new Mensaje(CodigoMensaje.M00038,
                "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de los perfiles en la tabla \"Perfil\" de la base de datos PostgreSQL."));

        mensajes.put((CodigoMensaje.M00039.getIdentificador()),new Mensaje(CodigoMensaje.M00039,
                "Se ha presentado un problema tratando de consultar las divisas. Por favor, contacte al administrador del sistema."));

        mensajes.put((CodigoMensaje.M00040.getIdentificador()),new Mensaje(CodigoMensaje.M00040,
                "Se ha presentado una SQLException tratando de realizar la consulta de las divisas en la tabla \"Divisa\" de la base de datos PostgreSQL." ));

        mensajes.put((CodigoMensaje.M00041.getIdentificador()), new Mensaje(CodigoMensaje.M00041,
                "Se ha presentado un problema tratando de consultar las divisas. Por favor, contacte al administrador del sistema."));

        mensajes.put((CodigoMensaje.M00042.getIdentificador()), new Mensaje(CodigoMensaje.M00042,
                "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de las divisas en la tabla \"Divisa\" de la base de datos PostgreSQL."));

        mensajes.put((CodigoMensaje.M00043.getIdentificador()), new Mensaje(CodigoMensaje.M00043,
                "Se ha presentado un problema tratando de llevar a cabo la consulta de los tipos de documento"));

        mensajes.put((CodigoMensaje.M00044.getIdentificador()), new Mensaje(CodigoMensaje.M00044,
                "El DAOFactory de consultar los tiposDocumentos llego nulo..."));

        mensajes.put((CodigoMensaje.M00045.getIdentificador()), new Mensaje(CodigoMensaje.M00045,
                "Se ha presentado un problema tratando de llevar la consulta de los perfiles"));

        mensajes.put((CodigoMensaje.M00046.getIdentificador()), new Mensaje(CodigoMensaje.M00046,
                "El DAOFactory de consultar los perfiles llego nulo..."));

        mensajes.put((CodigoMensaje.M00047.getIdentificador()), new Mensaje(CodigoMensaje.M00047,
                "Se ha presentado un problema tratando de llevar la consulta de las divisas"));

        mensajes.put((CodigoMensaje.M00048.getIdentificador()), new Mensaje(CodigoMensaje.M00048,
                "El DAOFactory de consultar las divisas llego nulo..."));

        mensajes.put((CodigoMensaje.M00049.getIdentificador()), new Mensaje(CodigoMensaje.M00049,
                "Se ha presentado un problema tratando de consultar la informacion de las divisas"));

        mensajes.put((CodigoMensaje.M00050.getIdentificador()), new Mensaje(CodigoMensaje.M00050,
                "Se ha presentado un problema INESPERADO tratando de consultar las divisas"));

        mensajes.put((CodigoMensaje.M00051.getIdentificador()), new Mensaje(CodigoMensaje.M00051,
                "Se ha presentado un problema consultar la informacion de los perfiles"));

        mensajes.put((CodigoMensaje.M00052.getIdentificador()), new Mensaje(CodigoMensaje.M00052,
                "Se ha presentado un problema INESPERADO tratando de consultar los perfiles"));

        mensajes.put((CodigoMensaje.M00053.getIdentificador()), new Mensaje(CodigoMensaje.M00053,
                "Se ha presentado un problema tratando de registrar la información"));

        mensajes.put((CodigoMensaje.M00054.getIdentificador()), new Mensaje(CodigoMensaje.M00054,
                "Se ha presentado un problema INESPERADO tratando de registrar la información"));

        mensajes.put((CodigoMensaje.M00055.getIdentificador()), new Mensaje(CodigoMensaje.M00055,
                "Se ha presentado un problema consultar la informacion de los tipos de documentos"));

        mensajes.put((CodigoMensaje.M00056.getIdentificador()), new Mensaje(CodigoMensaje.M00056,
                "Se ha presentado un problema INESPERADO tratando de consultar los tiposDocumentos"));

        mensajes.put((CodigoMensaje.M00057.getIdentificador()), new Mensaje(CodigoMensaje.M00057,
                "Se ha presentado un problema tratando de registar el nuevo Perfil"));

        mensajes.put((CodigoMensaje.M00058.getIdentificador()), new Mensaje(CodigoMensaje.M00058,
                "Divisas consultadas exitosamente..."));

        mensajes.put((CodigoMensaje.M00059.getIdentificador()), new Mensaje(CodigoMensaje.M00059,
                "Perfiles consultados exitosamente..."));

        mensajes.put((CodigoMensaje.M00060.getIdentificador()), new Mensaje(CodigoMensaje.M00060,
                "Tipos de documento consultados exitosamente..."));

        mensajes.put((CodigoMensaje.M00061.getIdentificador()), new Mensaje(CodigoMensaje.M00061,
                "Perfil registrado exitosamente..."));

        mensajes.put((CodigoMensaje.M00062.getIdentificador()), new Mensaje(CodigoMensaje.M00062,
                "El DAO Factory para registrar el perfil llegó nulo"));

        mensajes.put((CodigoMensaje.M00063.getIdentificador()), new Mensaje(CodigoMensaje.M00063,
                "No puede ser nulo"));

        mensajes.put((CodigoMensaje.M00064.getIdentificador()), new Mensaje(CodigoMensaje.M00064,
                "Debe contener solo letras..."));

        mensajes.put((CodigoMensaje.M00065.getIdentificador()), new Mensaje(CodigoMensaje.M00065,
                "Debe tener entre 1 y 20 caracteres..."));

        mensajes.put((CodigoMensaje.M00066.getIdentificador()), new Mensaje(CodigoMensaje.M00066,
                "El nombre de usuario debe contener solo letras y números..."));

        mensajes.put((CodigoMensaje.M00067.getIdentificador()), new Mensaje(CodigoMensaje.M00067,
                "El nombre de usuario debe tener entre 1 y 25 caracteres.."));

        mensajes.put((CodigoMensaje.M00068.getIdentificador()), new Mensaje(CodigoMensaje.M00068,
                "La contraseña debe contener como minimo entre 8 y 30 caracteres..."));

        mensajes.put((CodigoMensaje.M00069.getIdentificador()), new Mensaje(CodigoMensaje.M00069,
                "La contraseña debe contener como minimo un número , una letra mayúscula, una minuscula y un caracter especial..."));

        mensajes.put((CodigoMensaje.M00070.getIdentificador()), new Mensaje(CodigoMensaje.M00070,
                "El correo electrónico no tiene un formato válido"));

        mensajes.put((CodigoMensaje.M00071.getIdentificador()), new Mensaje(CodigoMensaje.M00071,
                "El correo debe tener entre 6 y 256 caracteres"));

        mensajes.put((CodigoMensaje.M00072.getIdentificador()), new Mensaje(CodigoMensaje.M00072,
                "Ya existe un perfil con el mismo nombre de usuario..."));

        mensajes.put((CodigoMensaje.M00073.getIdentificador()), new Mensaje(CodigoMensaje.M00073,
                "Ya existe un peril con el mismo correo electrónico asociado..."));

        mensajes.put((CodigoMensaje.M00074.getIdentificador()), new Mensaje(CodigoMensaje.M00074,
                "Ya existe un peril con el mismo número de documento..."));

        mensajes.put((CodigoMensaje.M00075.getIdentificador()), new Mensaje(CodigoMensaje.M00075,
                "Los datos proporcionados, no cumplen con los requisitos (tipo de dato, obligaoriedad, longitud, formato y rango)..."));

        mensajes.put((CodigoMensaje.M00076.getIdentificador()), new Mensaje(CodigoMensaje.M00076,
                "Alguno de los datos que se ingresaron y son únicos de cada perfil,ya se encuentran registrados en la base de datos."));
    }

    @Override
    public String obtenerContendidoMensaje(CodigoMensaje codigo, String... parametros) {
        return obtenerMensaje(codigo,parametros).getContenido();
    }

    @Override
    public Mensaje obtenerMensaje(CodigoMensaje codigo, String... parametros) {
        if(ObjectHelper.getObjectHelper().isNull(codigo)){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico =  MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
        }
        if(codigo.isBase()) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = TextHelper.reemplazarParametro(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00005,codigo.getIdentificador()));
            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
        }
        if(!mensajes.containsKey(codigo.getIdentificador())) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = TextHelper.reemplazarParametro(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00006,codigo.getIdentificador()));
            throw new CrosscuttingZBANKException(mensajeTecnico, mensajeUsuario);
        }
        return mensajes.get(codigo.getIdentificador());
    }
}
