package com.example.MicroUsuarioYSeguridad.controller;

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

import com.example.MicroUsuarioYSeguridad.modelo.Genero;
import com.example.MicroUsuarioYSeguridad.service.GeneroService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v2/generos")
public class GeneroController {
    @Autowired
    private GeneroService generoService;
    
    @GetMapping
    public List<Genero> listarGeneros(){
        return generoService.getGenero();
    }
    //agregar
    @PostMapping
    public Genero agregarGenero(@Valid @RequestBody Genero genero){
        return generoService.saveGenero(genero);
    }
    //buscar
    @GetMapping("/{id_genero}")
    public Genero buscarGenero(@PathVariable int id_genero){
           return generoService.getGenero(id_genero); 
        }
    //actualizar
    @PutMapping("/{id_genero}")
    public int actualizarGenero(@PathVariable int id_genero, @Valid @RequestBody Genero genero){
        return generoService.updateGenero(genero);
    }
    //eliminar
    @DeleteMapping("/{id_genero}")
    public String eliminarGenero(@PathVariable int id_genero){
        if (generoService.deleteGenero(id_genero)== 1) {
            return "Genero eliminado correctamente";
        }
        return "Error al eliminar el genero";
     }

}
