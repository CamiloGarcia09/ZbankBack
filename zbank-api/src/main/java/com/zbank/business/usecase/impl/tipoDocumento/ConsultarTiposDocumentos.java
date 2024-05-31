package com.zbank.business.usecase.impl.tipoDocumento;

import com.zbank.business.assembler.entity.impl.TipoDocumentoAssemblerEntity;
import com.zbank.business.domain.TipoDocumentoDomain;
import com.zbank.business.usecase.UseCaseWithReturn;
import com.zbank.crosscutting.exceptions.custom.BusinessZBANKException;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.crosscutting.helpers.ObjectHelper;
import com.zbank.data.dao.factory.DAOFactory;

import java.util.List;

public class ConsultarTiposDocumentos implements UseCaseWithReturn<TipoDocumentoDomain, List<TipoDocumentoDomain>> {

    private DAOFactory factory;

    public ConsultarTiposDocumentos(final DAOFactory factory){
        if (ObjectHelper.getObjectHelper().isNull(factory)){
            var mensajeUsuario=MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00043);
            var mensajeTecnico= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00044);
            throw new BusinessZBANKException(mensajeTecnico,mensajeUsuario);
        }
        this.factory=factory;
    }

    @Override
    public List<TipoDocumentoDomain> execute(final TipoDocumentoDomain data) {
        var tipoDocumentoEntityFilter= TipoDocumentoAssemblerEntity.getInstance().toEntity(data);
        var resultadosEntity=factory.getTipoDocumentoDAO().consultar(tipoDocumentoEntityFilter);
        return TipoDocumentoAssemblerEntity.getInstance().toDomainCollection(resultadosEntity);
    }
}