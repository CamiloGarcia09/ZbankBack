package com.zbank.business.usecase.impl.perfil;

import com.zbank.business.assembler.entity.impl.DivisaAssemblerEntity;
import com.zbank.business.assembler.entity.impl.TipoDocumentoAssemblerEntity;
import com.zbank.business.domain.PerfilDomain;
import com.zbank.business.usecase.UseCaseWithOutReturn;
import static com.zbank.crosscutting.helpers.ObjectHelper.getObjectHelper;

import com.zbank.crosscutting.exceptions.custom.BusinessZBANKException;
import com.zbank.crosscutting.helpers.TextHelper;
import com.zbank.crosscutting.helpers.UUIDHelper;
import com.zbank.data.dao.factory.DAOFactory;
import com.zbank.entity.PerfilEntity;

import java.util.UUID;

public class RegistrarPerfil implements UseCaseWithOutReturn<PerfilDomain> {

    private DAOFactory factory;

    public RegistrarPerfil(final DAOFactory factory) {
        if (getObjectHelper().isNull(factory)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo el registro de una ciudad";
            var mensajeTecnico = "El DAOFactory para crear la ciudad llegó nulo...";
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
    }

    @Override
    public void execute(final PerfilDomain data) {
        validarAtributos(data);
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

    private void validarAtributos(final PerfilDomain data) {

        if (!TextHelper.SoloLetras(data.getNombre())) {
            throw new IllegalArgumentException("El nombre debe contener solo letras.");
        }
        if (!validarLongitudAtributo(data.getNombre(), 1, 20)) {
            throw new IllegalArgumentException("El nombre debe tener entre 1 y 20 caracteres.");
        }
        if (!TextHelper.SoloLetras(data.getApellido())) {
            throw new IllegalArgumentException("El apellido debe contener solo letras.");
        }
        if (!validarLongitudAtributo(data.getApellido(), 1, 20)) {
            throw new IllegalArgumentException("El apellido debe tener entre 1 y 20 caracteres.");
        }
        if (!TextHelper.contieneSoloDigitos(String.valueOf(data.getNumeroDocumento()))) {
            throw new IllegalArgumentException("El número de documento debe contener solo dígitos.");
        }
        if (!validarLongitudAtributo(String.valueOf(data.getNumeroDocumento()), 1, 20)) {
            throw new IllegalArgumentException("El número de documento debe tener entre 1 y 20 caracteres.");
        }
        if (!TextHelper.SoloLetrasDigitosEspacios(data.getNombreUsuario())) {
            throw new IllegalArgumentException("El nombre de usuario solo puede contener letras y números.");
        }
        if (!validarLongitudAtributo(data.getNombreUsuario(), 1, 25)) {
            throw new IllegalArgumentException("El nombre de usuario debe tener entre 1 y 25 caracteres.");
        }
        if (!TextHelper.validarClave(String.valueOf(data.getClave()))){
            throw new IllegalArgumentException("La contraseña debe tener como minimo una letra mayuscula, una minuscula, " +
                    "un numero y un caracter especial.");
        }
        if (!validarLongitudAtributo(data.getClave(), 8, 30)) {
            throw new IllegalArgumentException("La clave debe tener entre 8 y 30 caracteres.");
        }
        if (!TextHelper.contieneFormatoCorreo(data.getCorreo())) {
            throw new IllegalArgumentException("El correo electrónico no tiene un formato válido.");
        }
        if (!validarLongitudAtributo(data.getCorreo(), 6, 100)) {
            throw new IllegalArgumentException("El correo debe tener entre 6 y 100 caracteres.");
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
            throw new IllegalArgumentException("Ya existe un perfil con el mismo nombre de usuario.");
        }
    }

    private void validarPerfilMismoCorreo(String correo) {
        var perfilEntity = PerfilEntity.build().setCorreo(correo);
        var resultados = factory.getPerfilDAO().consultar(perfilEntity);
        if (!resultados.isEmpty()) {
            throw new IllegalArgumentException("Ya existe un perfil con el mismo correo.");
        }
    }

    private void validarPerfilMismoNumeroDocumento(int numeroDocumento) {
        var perfilEntity = PerfilEntity.build().setNumeroDocumento(numeroDocumento);
        var resultados = factory.getPerfilDAO().consultar(perfilEntity);
        if (!resultados.isEmpty()) {
            throw new IllegalArgumentException("Ya existe un perfil con el mismo número de documento.");
        }
    }

    public boolean validarLongitudAtributo(String atributo, int longitudMinima, int longitudMaxima) {
        return TextHelper.longitudMinimaPermitida(atributo, longitudMinima) &&
                TextHelper.longitudMaximaPermitida(atributo, longitudMaxima);
    }
}
