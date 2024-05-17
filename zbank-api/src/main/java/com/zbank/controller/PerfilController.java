package com.zbank.controller;

import com.zbank.data.PerfilData;
import com.zbank.entity.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class PerfilController {

    @Autowired
    private PerfilData perfilData;

    @GetMapping("/persona")
    public List<Perfil> listarPerfiles(){
        return perfilData.findAll();
    }

    @PostMapping("/persona/registrar")
    public Perfil registrarPerfil(@RequestBody Perfil perfil){
        return perfilData.save(perfil);
    }

}
