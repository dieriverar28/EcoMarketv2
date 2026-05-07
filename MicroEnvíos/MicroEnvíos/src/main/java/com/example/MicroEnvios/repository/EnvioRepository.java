package com.example.MicroEnvios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.EcoMarketSPA.model.Envio;

@Repository

public interface EnvioRepository  extends JpaRepository<Envio, Integer> {
    
    @Query("SELECT e FROM Envio e")
    List<Envio> obtenerEnvios();

    @Query("SELECT e FROM Envio e WHERE e.id_envio = :id_envio")
    Envio buscarEnvio(int id_envio);

}
