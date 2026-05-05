package com.example.MicroUsuarioYSeguridad.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.MicroUsuarioYSeguridad.modelo.Genero;


@Repository
public class GeneroRepository {
    //Lista para guardar genero
    private List<Genero>generos=new ArrayList<>();

    //OBTNENER TODOS
    public List<Genero> obtenerGenero(){
        return generos;
    }

    // ELIMINAR POR ID
    public int eliminarGenero(int id_genero) {
        for (int i = 0; i < generos.size(); i++) {
            if (generos.get(i).getId_genero() == id_genero) {
                generos.remove(i);
                return 1;
            }
        }
        return 0;
    }

    // GUARDAR genero
    public Genero guardarGenero(Genero genero) {
        generos.add(genero);
        return genero;
    }

    // OBTENER POR ID
    public Genero obtenerGeneroPorId(int id_genero) {
        for (Genero genero : generos) {
            if (genero.getId_genero() == id_genero) {
                return genero;
            }
        }
        return null;
    }

    // MODIFICAR genero
    public int modificarGenero(Genero genero) {
    try {
        for (int i = 0; i < generos.size(); i++) {
            if (generos.get(i).getId_genero() == genero.getId_genero()) {
                generos.get(i).setDescripcion(genero.getDescripcion());
                return 1; // modificado
            }
        }
        return 0; // no encontrado
    } catch (Exception e) {
        return -1; // error
    }
    }

}
