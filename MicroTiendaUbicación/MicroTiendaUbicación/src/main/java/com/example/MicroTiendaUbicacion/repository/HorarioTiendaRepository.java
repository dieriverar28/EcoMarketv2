package com.example.MicroTiendaUbicacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MicroTiendaUbicacion.modelo.HorarioTienda;


@Repository
public interface HorarioTiendaRepository extends JpaRepository<HorarioTienda, Integer> {
    
    @Query("SELECT h FROM HorarioTienda h")
    List<HorarioTienda> obtenerHorarioTiendas();

    @Query("SELECT h FROM HorarioTienda h WHERE h.id_horario = :id_horario")
    HorarioTienda buscarHorarioTienda(@Param("id_horario") int id_horario);

}
