package com.zbank.controller;

import com.zbank.business.facade.impl.perfil.ConsultarPerfilesFacade;
import com.zbank.controller.response.PerfilResponse;
import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.dto.PerfilDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping
public final class PerfilController {

    @GetMapping("/dummy")
    public PerfilDTO dummy(){
        return PerfilDTO.build();
    }

    @GetMapping("/p")
    public ResponseEntity<PerfilResponse> consultar(){

        var httpStatusCode = HttpStatus.ACCEPTED;
        var ciudadResponse = new PerfilResponse();

        try {

            var ciudadesDto = PerfilDTO.build();
            var facade = new ConsultarPerfilesFacade();

            var ciudadesRetorno=new ArrayList<PerfilDTO>();
            ciudadesRetorno.add(PerfilDTO.build());
            ciudadesRetorno.add(PerfilDTO.build());
            ciudadesRetorno.add(PerfilDTO.build());
            ciudadesRetorno.add(PerfilDTO.build());
            ciudadResponse.setDatos(facade.execute(ciudadesDto));
            ciudadResponse.getMensajes().add("Perfiles consultados exitosamente");
        }catch (final ZBANKException exception){
            httpStatusCode = HttpStatus.BAD_REQUEST;
            ciudadResponse.getMensajes().add(exception.getMensajeUsuario());
            exception.printStackTrace();
        }catch (final Exception exception){
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "Se ha presntado un problema tratando de consultar los perfiles";
            ciudadResponse.getMensajes().add(mensajeUsuario);

            exception.printStackTrace();

        }

        return new ResponseEntity<>(ciudadResponse, httpStatusCode);
    }
}
