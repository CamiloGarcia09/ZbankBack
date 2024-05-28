package com.zbank.business.facade.impl.perfil;

import com.zbank.business.assembler.dto.impl.PerfilAssemblerDTO;
import com.zbank.business.facade.FacadeWithOutReturn;
import com.zbank.business.usecase.impl.perfil.RegistrarPerfil;
import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.crosscutting.exceptions.custom.BusinessZBANKException;
import com.zbank.data.dao.factory.DAOFactory;
import com.zbank.dto.PerfilDTO;

public final class RegistrarPerfilFacade implements FacadeWithOutReturn <PerfilDTO> {

    private DAOFactory daoFactory;

    public RegistrarPerfilFacade() {
        daoFactory= DAOFactory.getFactory();
    }

    @Override
    public void execute(PerfilDTO dto) {

        daoFactory.iniciarTransaccion();

        try {
            var useCase=new RegistrarPerfil(daoFactory);
            var perfilDomain= PerfilAssemblerDTO.getInstance().toDomain(dto);
            useCase.execute(perfilDomain);

            daoFactory.confirmarTransaccion();
        }catch(final ZBANKException excepcion){
            daoFactory.cancelarTransaccion();
            throw excepcion;
        }catch(final Exception excepcion) {
            daoFactory.cancelarTransaccion();

            var mensajeUsuario=("Se ha presentado un problema tratando de registrar la información");
            var mensajeTecnico=("Se ha presentado un problema INESPERADO tratando de registrar la información");

            throw new BusinessZBANKException(mensajeTecnico,mensajeUsuario,excepcion);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
