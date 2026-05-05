package com.example.MicroPostventa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MicroPostventa.modelo.ResenaCalificacion;

@Repository
public interface ResenaCalificacionRepository extends JpaRepository<ResenaCalificacion, Integer> {
    
    @Query("SELECT r FROM ResenaCalificacion r")
    List<ResenaCalificacion> obtenerResenaCalificacion();

    @Query("SELECT r FROM ResenaCalificacion r WHERE r.id_resena = :id_resena")
    ResenaCalificacion buscarResenaCalificacion(int id_resena);
}
