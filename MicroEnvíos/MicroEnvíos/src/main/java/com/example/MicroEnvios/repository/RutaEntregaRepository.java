package com.example.MicroEnvios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.EcoMarketSPA.model.RutaEntrega;

@Repository
public interface RutaEntregaRepository extends JpaRepository<RutaEntrega, Integer> {

    @Query("SELECT r FROM RutaEntrega r")
    List<RutaEntrega> obtenerRutaEntrega();

    @Query("SELECT r FROM RutaEntrega r WHERE r.id_ruta = :id_ruta")
    RutaEntrega buscarRutaEntrega(int id_ruta);

}
