package com.example.MicroPostventa.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroPostventa.modelo.ResenaCalificacion;
import com.example.MicroPostventa.repository.ResenaCalificacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ResenaCalificacionService {
    @Autowired
    private ResenaCalificacionRepository resenaCalificacionRepository;

    //obtener
    public List<ResenaCalificacion> getResenaCalificaciones(){
        return resenaCalificacionRepository.obtenerResenaCalificacion();
    }
    //bucar
    public ResenaCalificacion getResenaCalificacion(int id_resena_calificacion){
        ResenaCalificacion resenaCalificacion = resenaCalificacionRepository.buscarResenaCalificacion(id_resena_calificacion);
        if (resenaCalificacion!=null) {
            return resenaCalificacion;
        }else
        return new ResenaCalificacion();
    }
    //eliminar
    public int deleteResenaCalificacion(int id_resena_calificacion){
        resenaCalificacionRepository.deleteById(id_resena_calificacion);
        return 1;
    }
    //guardar
    public ResenaCalificacion saveResenaCalificacion(ResenaCalificacion resenaCalificacion){
        return resenaCalificacionRepository.save(resenaCalificacion);
    }
    //modificar
    public ResenaCalificacion updateResenaCalificacion(int id_resena_calificacion, ResenaCalificacion resenaCalificacion){
        ResenaCalificacion resenaExistente = getResenaCalificacion(id_resena_calificacion);
        if (resenaExistente != null && resenaExistente.getId_resena() != 0) {
            resenaCalificacion.setId_resena(id_resena_calificacion);
            return resenaCalificacionRepository.save(resenaCalificacion);
        }
        return null;
    }


}
