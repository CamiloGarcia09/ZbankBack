package com.zbank.controller.response;

import com.zbank.dto.DivisaDTO;

import java.util.ArrayList;

public class DivisaResponse extends Response<DivisaDTO>{
    public DivisaResponse(){
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}
