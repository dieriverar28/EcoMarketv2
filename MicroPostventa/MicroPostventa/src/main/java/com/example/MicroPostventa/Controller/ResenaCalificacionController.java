package com.example.MicroPostventa.Controller;

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

import com.example.MicroPostventa.modelo.ResenaCalificacion;
import com.example.MicroPostventa.service.ResenaCalificacionService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v2/resenas_calificaciones")
public class ResenaCalificacionController {
    @Autowired
    private ResenaCalificacionService resenaCalificacionService;

    @GetMapping
    public List<ResenaCalificacion> listarResenasCalificaciones(){
        return resenaCalificacionService.getResenaCalificaciones();
    }
    //agregar
    @PostMapping
    public ResenaCalificacion agregarResenaCalificacion(@Valid @RequestBody ResenaCalificacion resenaCalificacion){
        return resenaCalificacionService.saveResenaCalificacion(resenaCalificacion);
    }

    //buscar
    @GetMapping("/{id_resena_calificacion}")
    public ResenaCalificacion buscarResenaCalificacion(@PathVariable int id_resena_calificacion){
        return resenaCalificacionService.getResenaCalificacion(id_resena_calificacion);
    }
    //actualizar
    @PutMapping("/{id_resena_calificacion}")
    public ResenaCalificacion actualizarResenaCalificacion(@PathVariable int id_resena_calificacion, @Valid @RequestBody ResenaCalificacion resenaCalificacion){
        return resenaCalificacionService.updateResenaCalificacion(id_resena_calificacion, resenaCalificacion);
    }
    //eliminar
    @DeleteMapping("/{id_resena_calificacion}")
    public String eliminarResenaCalificacion(@PathVariable int id_resena_calificacion){
        if (resenaCalificacionService.deleteResenaCalificacion(id_resena_calificacion)== 1) {
            return "Reseña de calificación eliminada correctamente";
        }
        return "Error al eliminar la reseña de calificación";
    }

}
