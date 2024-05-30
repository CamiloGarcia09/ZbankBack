package com.zbank.controller;

import com.zbank.business.facade.impl.divisa.ConsultarDivisasFacade;
import com.zbank.controller.response.DivisaResponse;
import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.dto.DivisaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zbank")
public class DivisaController {

    @GetMapping("/divisas")
    public ResponseEntity<DivisaResponse> consultar(){

        var httpStatusCode = HttpStatus.ACCEPTED;
        var divisaResponse = new DivisaResponse();

        try {
            var divisaDto = DivisaDTO.build();
            var facade = new ConsultarDivisasFacade();

            divisaResponse.setDatos(facade.execute(divisaDto));
            divisaResponse.getMensajes().add("Divisas consultadas exitosamente");

        }catch(final ZBANKException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            divisaResponse.getMensajes().add(excepcion.getMensajeUsuario());
            excepcion.printStackTrace();
        }catch(final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las divisas";
            divisaResponse.getMensajes().add(mensajeUsuario);

            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(divisaResponse,httpStatusCode);
    }
}