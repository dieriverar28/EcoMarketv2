package com.example.MicroEnvios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcoMarketSPA.model.Envio;
import com.example.EcoMarketSPA.service.EnvioService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v2/envios")
public class EnvioController {
    @Autowired
    private EnvioService envioService;
    
    @GetMapping
    public List<Envio> listarEnvios(){
        return envioService.getEnvios();
    }

    //agregar
    @PostMapping
    public Envio agregarEnvio(@Valid @RequestBody Envio envio){
        return envioService.saveCupon(envio);//EMVIO******
     }

    //buscar
     @GetMapping("/{id_envio}")
     public Envio buscarEnvio(@PathVariable int id_envio){
        return envioService.getEnvio(id_envio);
     }
    //actualizar
    @PutMapping("/{id_envio}")
    public int actualizarEnvio(@PathVariable int id_envio, @Valid @RequestBody Envio envio){
        return envioService.updateEnvio(envio);
     }
    //eliminar
    @DeleteMapping("/{id_envio}")
    public String eliminarEnvio(@PathVariable int id_envio){
        if (envioService.deleteEnvio(id_envio)== 1) {
            return "Envio eliminado correctamente";
        }
        return "Error al eliminar el envio";
     }

}
