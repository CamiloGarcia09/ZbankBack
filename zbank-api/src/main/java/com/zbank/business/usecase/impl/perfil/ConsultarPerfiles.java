package com.zbank.business.usecase.impl.perfil;

import com.zbank.business.assembler.entity.impl.PerfilAssemblerEntity;
import com.zbank.business.domain.PerfilDomain;
import com.zbank.business.usecase.UseCaseWithReturn;
import com.zbank.crosscutting.exceptions.custom.BusinessZBANKException;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.crosscutting.helpers.ObjectHelper;
import com.zbank.data.dao.factory.DAOFactory;

import java.util.List;

public class ConsultarPerfiles implements UseCaseWithReturn<PerfilDomain, List<PerfilDomain>> {

    private DAOFactory factory;

    public ConsultarPerfiles(final DAOFactory factory){
        if (ObjectHelper.getObjectHelper().isNull(factory)){
            var mensajeUsuario=MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00045);
            var mensajeTecnico= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00046);
            throw new BusinessZBANKException(mensajeTecnico,mensajeUsuario);
        }
        this.factory=factory;
    }

    @Override
    public List<PerfilDomain> execute(final PerfilDomain data) {
        var perfilEntityFilter= PerfilAssemblerEntity.getInstance().toEntity(data);
        var resultadosEntity=factory.getPerfilDAO().consultar(perfilEntityFilter);
        return PerfilAssemblerEntity.getInstance().toDomainCollection(resultadosEntity);
    }
}
