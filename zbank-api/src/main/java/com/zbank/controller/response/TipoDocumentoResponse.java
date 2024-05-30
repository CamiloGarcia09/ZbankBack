package com.zbank.controller.response;

import com.zbank.dto.TipoDocumentoDTO;

import java.util.ArrayList;

public class TipoDocumentoResponse extends Response<TipoDocumentoDTO>{
    public TipoDocumentoResponse(){
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}
