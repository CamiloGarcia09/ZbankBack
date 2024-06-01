package com.zbank.business.usecase.impl.perfil;

import com.zbank.business.assembler.entity.impl.DivisaAssemblerEntity;
import com.zbank.business.assembler.entity.impl.TipoDocumentoAssemblerEntity;
import com.zbank.business.domain.PerfilDomain;
import com.zbank.business.usecase.UseCaseWithOutReturn;
import static com.zbank.crosscutting.helpers.ObjectHelper.getObjectHelper;

import com.zbank.crosscutting.exceptions.custom.BusinessZBANKException;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;
import com.zbank.data.dao.factory.DAOFactory;
import com.zbank.entity.PerfilEntity;

import java.util.UUID;

public class RegistrarPerfil implements UseCaseWithOutReturn<PerfilDomain> {

    private DAOFactory factory;

    public RegistrarPerfil(final DAOFactory factory) {
        if (getObjectHelper().isNull(factory)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00057);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00062);
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
    }

    @Override
    public void execute(final PerfilDomain data) {
        validarNombre(data.getNombre());
        validarApellido(data.getApellido());
        validarNumeroDocumento(data.getNumeroDocumento());
        validarNombreUsuario(data.getNombreUsuario());
        validarClave(data.getClave());
        validarCorreo(data.getCorreo());
        validarPerfilMismoNombreUsuario(data.getNombreUsuario());
        validarPerfilMismoCorreo(data.getCorreo());
        validarPerfilMismoNumeroDocumento(data.getNumeroDocumento());

        var perfilEntity = PerfilEntity.build()
                .setId(generarIdentificadorPerfil())
                .setNombre(data.getNombre())
                .setApellido(data.getApellido())
                .setTipoDocumento(TipoDocumentoAssemblerEntity.getInstance().toEntity(data.getTipoDocumento()))
                .setNumeroDocumento(data.getNumeroDocumento())
                .setDivisa(DivisaAssemblerEntity.getInstance().toEntity(data.getDivisa()))
                .setNombreUsuario(data.getNombreUsuario())
                .setClave(data.getClave())
                .setCorreo(data.getCorreo());

        factory.getPerfilDAO().crear(perfilEntity);
    }

    private void validarNombre(String nombre) {
        if (nombre == null) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00063);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
        if (!TextHelper.SoloLetras(nombre)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00064);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
        if (!validarLongitudAtributo(nombre, 1, 20)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00065);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
    }

    private void validarApellido(String apellido) {
        if (apellido == null) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00063);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
        if (!TextHelper.SoloLetras(apellido)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00064);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
        if (!validarLongitudAtributo(apellido, 1, 20)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00065);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico,mensajeUsuario);
        }
    }

    private void validarNumeroDocumento(long numeroDocumento) {
        String numeroDocumentoStr = String.valueOf(numeroDocumento);
        if (!TextHelper.contieneSoloDigitos(numeroDocumentoStr)) {
            throw new BusinessZBANKException("El número de documento debe contener solo numeros.");
        }
        if (!validarLongitudAtributo(numeroDocumentoStr, 1, 10)) {
            throw new BusinessZBANKException("El número de documento debe tener entre 1 y 20 caracteres.");
        }
    }

    private void validarNombreUsuario(String nombreUsuario) {
        if (nombreUsuario == null) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00063);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico,mensajeUsuario);
        }
        if (!TextHelper.SoloLetrasDigitosEspacios(nombreUsuario)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00066);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
        if (!validarLongitudAtributo(nombreUsuario, 1, 25)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00067);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico,mensajeUsuario);
        }
    }

    private void validarClave(String clave) {
        if (clave == null) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00063);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
        if (!TextHelper.validarClave(clave)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00069);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
        if (!validarLongitudAtributo(clave, 8, 30)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00068);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
    }

    private void validarCorreo(String correo) {
        if (correo == null) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00063);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
        if (!TextHelper.contieneFormatoCorreo(correo)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00070);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
        if (!validarLongitudAtributo(correo, 6, 256)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00071);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
    }


    private final UUID generarIdentificadorPerfil() {
        UUID id = UUIDHelper.generate();
        boolean existeId = true;

        while (existeId) {
            id = UUIDHelper.generate();
            var perfilEntity = PerfilEntity.build().setId(id);
            var resultados = factory.getPerfilDAO().consultar(perfilEntity);
            existeId = !resultados.isEmpty();
        }
        return id;
    }

    private void validarPerfilMismoNombreUsuario(String nombreUsuario) {
        var perfilEntity = PerfilEntity.build().setNombreUsuario(nombreUsuario);
        var resultados = factory.getPerfilDAO().consultar(perfilEntity);
        if (!resultados.isEmpty()) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00072);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00076);
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
    }

    private void validarPerfilMismoCorreo(String correo) {
        var perfilEntity = PerfilEntity.build().setCorreo(correo.toLowerCase());
        var resultados = factory.getPerfilDAO().consultar(perfilEntity);
        if (!resultados.isEmpty()) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00073);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00076);
            throw new BusinessZBANKException(mensajeTecnico,mensajeUsuario);
        }
    }

    private void validarPerfilMismoNumeroDocumento(long numeroDocumento) {
        var perfilEntity = PerfilEntity.build().setNumeroDocumento(numeroDocumento);
        var resultados = factory.getPerfilDAO().consultar(perfilEntity);
        if (!resultados.isEmpty()) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00074);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00076);
            throw new BusinessZBANKException(mensajeTecnico,mensajeUsuario);
        }
    }

    public boolean validarLongitudAtributo(String atributo, int longitudMinima, int longitudMaxima) {
        return TextHelper.longitudMinimaPermitida(atributo, longitudMinima) &&
                TextHelper.longitudMaximaPermitida(atributo, longitudMaxima);
    }
}