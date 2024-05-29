package com.zbank.controller.response;

import com.zbank.dto.PerfilDTO;

import java.util.ArrayList;

public class PerfilResponse extends Response<PerfilDTO> {
    public PerfilResponse(){
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}
