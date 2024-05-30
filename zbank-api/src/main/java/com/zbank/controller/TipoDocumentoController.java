package com.zbank.controller;

import com.zbank.business.facade.impl.tipoDocumento.ConsultarTiposDocumentosFacade;
import com.zbank.controller.response.TipoDocumentoResponse;
import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.dto.TipoDocumentoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zbank")
public class TipoDocumentoController {

    @GetMapping("/tiposDocumentos")
    public ResponseEntity<TipoDocumentoResponse> consultar(){

        var httpStatusCode = HttpStatus.ACCEPTED;
        var tipoDocumentoResponse = new TipoDocumentoResponse();

        try {
            var tipoDocumentoDto = TipoDocumentoDTO.build();
            var facade = new ConsultarTiposDocumentosFacade();

            tipoDocumentoResponse.setDatos(facade.execute(tipoDocumentoDto));
            tipoDocumentoResponse.getMensajes().add("Tipos de Documentos consultados exitosamente");

        }catch(final ZBANKException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            tipoDocumentoResponse.getMensajes().add(excepcion.getMensajeUsuario());
            excepcion.printStackTrace();
        }catch(final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

            var mensajeUsuario = "Se ha presentado un problema tratando de consultar los tipos de documentos";
            tipoDocumentoResponse.getMensajes().add(mensajeUsuario);

            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(tipoDocumentoResponse,httpStatusCode);
    }
}
