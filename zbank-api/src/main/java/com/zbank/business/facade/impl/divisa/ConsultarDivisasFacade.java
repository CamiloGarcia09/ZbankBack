package com.zbank.business.facade.impl.divisa;
import com.zbank.business.assembler.dto.impl.DivisaAssemblerDTO;
import com.zbank.business.facade.FacadeWithReturn;
import com.zbank.business.usecase.impl.divisa.ConsultarDivisas;
import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.crosscutting.exceptions.custom.BusinessZBANKException;
import com.zbank.data.dao.factory.DAOFactory;
import com.zbank.dto.DivisaDTO;

import java.util.List;

public final class ConsultarDivisasFacade implements FacadeWithReturn<DivisaDTO, List<DivisaDTO>> {

    private DAOFactory daoFactory;

    public ConsultarDivisasFacade(){
        daoFactory = DAOFactory.getFactory();
    }

    @Override
    public List<DivisaDTO> execute(final DivisaDTO dto) {
        try {
            var usecase = new ConsultarDivisas(daoFactory);
            var divisaDomain = DivisaAssemblerDTO.getInstance().toDomain(dto);
            var resultadosDomain = usecase.execute(divisaDomain);
            return DivisaAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

        } catch (final ZBANKException exception) {
            throw exception;
        } catch (final Exception exception) {

            var mensajeUsuario = "Se ha presentado un problema consultar la informacion de las divisas";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar las divisas";

            throw new BusinessZBANKException(mensajeTecnico, mensajeUsuario, exception);

        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
