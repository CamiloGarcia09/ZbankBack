package com.zbank.controller;

import com.zbank.business.facade.impl.perfil.ConsultarPerfilesFacade;
import com.zbank.business.facade.impl.perfil.RegistrarPerfilFacade;
import com.zbank.controller.response.PerfilResponse;
import com.zbank.crosscutting.exceptions.ZBANKException;
import com.zbank.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import com.zbank.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import com.zbank.dto.PerfilDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/zbank")
@CrossOrigin(origins="http://localhost:3000")
public final class PerfilController {

    @GetMapping("/perfiles")
    public ResponseEntity<PerfilResponse> consultar(){

        var httpStatusCode = HttpStatus.ACCEPTED;
        var perfilResponse = new PerfilResponse();

        try {
            var perfilDto = PerfilDTO.build();
            var facade = new ConsultarPerfilesFacade();

            perfilResponse.setDatos(facade.execute(perfilDto));
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00059);
            perfilResponse.getMensajes().add(mensajeUsuario);

        }catch (final ZBANKException exception){
            httpStatusCode = HttpStatus.BAD_REQUEST;
            perfilResponse.getMensajes().add(exception.getMensajeUsuario());
            exception.printStackTrace();

        }catch (final Exception exception){
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00045);
            perfilResponse.getMensajes().add(mensajeUsuario);

            exception.printStackTrace();
        }
        return new ResponseEntity<>(perfilResponse, httpStatusCode);
    }

    @PostMapping("/crearperfil")
    public ResponseEntity<PerfilResponse> registrar(@RequestBody PerfilDTO perfil) {

        var httpStatusCode = HttpStatus.ACCEPTED;
        var perfilResponse = new PerfilResponse();

        try {
            var facade = new RegistrarPerfilFacade();
            facade.execute(perfil);
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00061);
             perfilResponse.getMensajes().add(mensajeUsuario);

        } catch (final ZBANKException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            perfilResponse.getMensajes().add(excepcion.getMensajeUsuario());
            excepcion.printStackTrace();
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00057);
            perfilResponse.getMensajes().add(mensajeUsuario);

            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(perfilResponse, httpStatusCode);

    }

}
