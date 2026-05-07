package com.example.MicroUsuarioYSeguridad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroUsuarioYSeguridad.modelo.Genero;
import com.example.MicroUsuarioYSeguridad.repository.GeneroRepository;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class GeneroService {
    @Autowired
    //llama repository
    private GeneroRepository generoRepository;
    //obtener todo
    public List<Genero> getGenero(){
        return generoRepository.obtenerGenero();
    }
    
    //obtener por id
    public Genero getGenero(int id_genero){
        return generoRepository.obtenerGeneroPorId(id_genero);
    }
    
    //eliminar x id_gemero
    public int deleteGenero(int id_genero){
        return generoRepository.eliminarGenero(id_genero);
    }
    //guardar genero
    public Genero saveGenero(Genero genero){
        return generoRepository.guardarGenero(genero);
    }
    //modificar genero 
    public int updateGenero(Genero genero){
        return generoRepository.modificarGenero(genero); 


    }

}
