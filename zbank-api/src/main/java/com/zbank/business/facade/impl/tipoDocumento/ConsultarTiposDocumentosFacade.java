package com.zbank.business.facade.impl.tipoDocumento;

import com.zbank.business.assembler.dto.impl.TipoDocumentoAssemblerDTO;
import com.zbank.business.facade.FacadeWithReturn;
import com.zbank.business.usecase.impl.tipoDocumento.ConsultarTiposDocumentos;
import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.crosscutting.exceptions.custom.BusinessZBANKException;
import com.zbank.data.dao.factory.DAOFactory;
import com.zbank.dto.TipoDocumentoDTO;

import java.util.List;

public final class ConsultarTiposDocumentosFacade implements FacadeWithReturn<TipoDocumentoDTO, List<TipoDocumentoDTO>> {

    private DAOFactory daoFactory;

    public ConsultarTiposDocumentosFacade(){
        daoFactory = DAOFactory.getFactory();
    }

    @Override
    public List<TipoDocumentoDTO> execute(final TipoDocumentoDTO dto) {
        try {
            var usecase = new ConsultarTiposDocumentos(daoFactory);
            var tipoDocumentoDomain = TipoDocumentoAssemblerDTO.getInstance().toDomain(dto);
            var resultadosDomain = usecase.execute(tipoDocumentoDomain);
            return TipoDocumentoAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

        } catch (final ZBANKException exception) {
            throw exception;
        } catch (final Exception exception) {

            var mensajeUsuario = "Se ha presentado un problema consultar la informacion de los tipos de documentos";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar los tiposDocumentos";

            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario, exception);

        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
