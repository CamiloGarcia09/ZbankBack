package com.zbank.business.facade.impl.perfil;

import com.zbank.business.assembler.dto.impl.PerfilAssemblerDTO;
import com.zbank.business.facade.FacadeWithReturn;
import com.zbank.business.usecase.impl.perfil.ConsultarPerfiles;
import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.crosscutting.exceptions.custom.BusinessZBANKException;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.data.dao.factory.DAOFactory;
import com.zbank.dto.PerfilDTO;

import java.util.List;

public final class ConsultarPerfilesFacade implements FacadeWithReturn<PerfilDTO, List<PerfilDTO>> {

    private DAOFactory daoFactory;

    public ConsultarPerfilesFacade(){
        daoFactory = DAOFactory.getFactory();
    }

    @Override
    public List<PerfilDTO> execute(final PerfilDTO dto) {
        try {
            var usecase = new ConsultarPerfiles(daoFactory);
            var perfilDomain = PerfilAssemblerDTO.getInstance().toDomain(dto);
            var resultadosDomain = usecase.execute(perfilDomain);
            return PerfilAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

        } catch (final ZBANKException exception) {
            throw exception;
        } catch (final Exception exception) {

            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00051);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00052);

            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario, exception);

        } finally {
            daoFactory.cerrarConexion();
        }
    }
}