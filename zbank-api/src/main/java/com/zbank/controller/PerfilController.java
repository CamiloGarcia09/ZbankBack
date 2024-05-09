package com.zbank.controller;

import com.zbank.crosscuting.exceptions.ResourceNotFoundExeption;
import com.zbank.data.PerfilData;
import com.zbank.entity.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class PerfilController {

    @Autowired
    private PerfilData perfilData;

    @GetMapping("/persona")
    public List<Perfil> listarPerfiles(){
        return perfilData.findAll();
    }

    @PostMapping("/persona")
    public Perfil registrarPerfil(@RequestBody Perfil perfil){
        return perfilData.save(perfil);
    }

    @GetMapping("/persona")
    public ResponseEntity<Perfil> buscarPerfilPorId(@PathVariable Long id){
        Perfil perfil = perfilData.findById(id).
                orElseThrow(() -> new ResourceNotFoundExeption("El perfil con ese id no existe: " + id));
        return ResponseEntity.ok(perfil);
    }
    
    @PutMapping("/persona/{id}")
    public ResponseEntity <Perfil> editarPerfil(@PathVariable Long id, @RequestBody Perfil perfilRequest){
        Perfil perfil = perfilData.findById(id).
                orElseThrow(() -> new ResourceNotFoundExeption("El perfil con ese id no existe: " + id));

        perfil.setNombre(perfilRequest.getNombre());
        perfil.setApellido(perfilRequest.getApellido());

        Perfil perfilActualizado = perfilData.save(perfil);
        return ResponseEntity.ok (perfilActualizado);
    }

    @DeleteMapping("/persona/{id}")
    public ResponseEntity <Map<String, Boolean>> eliminarPerfil(@PathVariable Long id){
        Perfil perfil = perfilData.findById(id).
                orElseThrow(() -> new ResourceNotFoundExeption("El perfil con ese id no existe: " + id));

        perfilData.delete(perfil);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
