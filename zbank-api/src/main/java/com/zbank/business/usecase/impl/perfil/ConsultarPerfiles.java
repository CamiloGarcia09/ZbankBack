package com.zbank.business.usecase.impl.perfil;

import com.zbank.business.assembler.entity.impl.PerfilAssemblerEntity;
import com.zbank.business.domain.PerfilDomain;
import com.zbank.business.usecase.UseCaseWithReturn;
import com.zbank.crosscutting.exceptions.custom.BusinessZBANKException;
import com.zbank.crosscutting.helpers.ObjectHelper;
import com.zbank.data.dao.factory.DAOFactory;

import java.util.List;

public class ConsultarPerfiles implements UseCaseWithReturn<PerfilDomain, List<PerfilDomain>> {

    private DAOFactory factory;

    public ConsultarPerfiles(final DAOFactory factory){
        if (ObjectHelper.getObjectHelper().isNull(factory)){
            var mensajeUsuario="Se ha presentado un prOblema tratando de llevar la consulta de los perfiles";
            var mensajeTecnico="El DAOFactory de consultar las ciudades llego nulo...";
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
