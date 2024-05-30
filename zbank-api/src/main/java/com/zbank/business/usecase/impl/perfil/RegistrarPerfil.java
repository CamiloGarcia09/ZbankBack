package com.zbank.business.usecase.impl.perfil;

import com.zbank.business.assembler.entity.impl.DivisaAssemblerEntity;
import com.zbank.business.assembler.entity.impl.TipoDocumentoAssemblerEntity;
import com.zbank.business.domain.PerfilDomain;
import com.zbank.business.usecase.UseCaseWithOutReturn;
import static com.zbank.crosscutting.helpers.ObjectHelper.getObjectHelper;

import com.zbank.crosscutting.exceptions.custom.BusinessZBANKException;
import com.zbank.crosscutting.helpers.UUIDHelper;
import com.zbank.data.dao.factory.DAOFactory;
import com.zbank.entity.PerfilEntity;

import java.util.UUID;

public class RegistrarPerfil implements UseCaseWithOutReturn<PerfilDomain> {

    private DAOFactory factory;

    public RegistrarPerfil(final DAOFactory factory) {

        if(getObjectHelper().isNull(factory)){
            var mensajeUsuario = "Se ha presentado un porblema tratando de llevar a cabo el registro de una ciudad";
            var mensajeTecnico = "El DAOFactory para crear la ciudad llego nulo...";
            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
    }

    @Override
    public void execute(final PerfilDomain data) {
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

    private final UUID generarIdentificadorPerfil(){

        UUID id= UUIDHelper.generate();
        boolean existeId=true;

        while (existeId){
            id=UUIDHelper.generate();
            var perfilEntity= PerfilEntity.build().setId(id);
            var resultados=factory.getPerfilDAO().consultar(perfilEntity);

            existeId=!resultados.isEmpty();
        }
        return id;
    }

   /* private final void validarPerfilMismoNombreUsuario{

    }
    private final void validarPerfilMismoCorreo{

    }

    private final void validarPerfilMismoNumeroDocumento{

    }*/
}
