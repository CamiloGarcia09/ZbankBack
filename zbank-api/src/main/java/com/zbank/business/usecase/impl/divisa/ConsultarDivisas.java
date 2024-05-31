package com.zbank.business.usecase.impl.divisa;

import com.zbank.business.assembler.entity.impl.DivisaAssemblerEntity;
import com.zbank.business.domain.DivisaDomain;
import com.zbank.business.usecase.UseCaseWithReturn;
import com.zbank.crosscutting.exceptions.custom.BusinessZBANKException;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.crosscutting.helpers.ObjectHelper;
import com.zbank.data.dao.factory.DAOFactory;

import java.util.List;

public class ConsultarDivisas implements UseCaseWithReturn<DivisaDomain, List<DivisaDomain>> {

    private DAOFactory factory;

    public ConsultarDivisas(final DAOFactory factory){
        if (ObjectHelper.getObjectHelper().isNull(factory)){
            var mensajeUsuario=MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00047);
            var mensajeTecnico= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00048);
            throw new BusinessZBANKException(mensajeTecnico,mensajeUsuario);
        }
        this.factory=factory;
    }

    @Override
    public List<DivisaDomain> execute(final DivisaDomain data) {
        var divisaEntityFilter=DivisaAssemblerEntity.getInstance().toEntity(data);
        var resultadosEntity=factory.getDivisaDAO().consultar(divisaEntityFilter);
        return DivisaAssemblerEntity.getInstance().toDomainCollection(resultadosEntity);
    }
}