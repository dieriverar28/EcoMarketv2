package com.example.MicroProducto.controller;


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

import com.example.EcoMarketSPA.model.Comuna;
import com.example.EcoMarketSPA.service.ComunaService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api/v2/comunas")
public class ComunaController {
    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public List<Comuna> listarComunas(){
        return comunaService.getComunas();
    }
    
   //agregar
   @PostMapping
   public Comuna agregarComuna(@Valid @RequestBody Comuna comuna){
         return comunaService.saveComunas(comuna);
   }
    //buscar
    @GetMapping("{id_comuna}")
    public Comuna buscarComuna(@PathVariable int id_comuna){
        return comunaService.getComunaById(id_comuna);
    }
    //actualizar
    @PutMapping("{id_comuna}")
    public int actualizarComuna(@PathVariable int id_comuna, @Valid @RequestBody Comuna comuna){
        return comunaService.updateComuna(comuna);
    }
    //eliminar
    @DeleteMapping("{id_comuna}")
    public String eliminarComuna(@PathVariable int id_comuna){
        if (comunaService.deleteComuna(id_comuna)==1){
            return "comuna eliminada correctamente";
        }
        return "Error al eliminar la comuna";
    }

}
