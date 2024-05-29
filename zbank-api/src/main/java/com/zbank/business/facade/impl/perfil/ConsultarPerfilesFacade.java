package com.zbank.business.facade.impl.perfil;

import com.zbank.business.assembler.dto.impl.PerfilAssemblerDTO;
import com.zbank.business.facade.FacadeWithReturn;
import com.zbank.business.usecase.impl.perfil.ConsultarPerfiles;
import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.crosscutting.exceptions.custom.BusinessZBANKException;
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
            var periflDomain = PerfilAssemblerDTO.getInstance().toDomain(dto);
            var resultadosDomain = usecase.execute(periflDomain);
            return PerfilAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

        } catch (final ZBANKException exception) {
            throw exception;
        } catch (final Exception exception) {

            var mensajeUsuario = "Se ha presentado un problema consultar la informacion de las ciudad";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar la ciudad";

            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario, exception);

        } finally {
            daoFactory.cerrarConexion();
        }
    }
}