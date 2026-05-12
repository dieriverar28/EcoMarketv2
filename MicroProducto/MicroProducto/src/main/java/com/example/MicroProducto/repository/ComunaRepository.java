package com.example.MicroProducto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.EcoMarketSPA.model.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Integer> {

    @Query("SELECT c FROM Comuna c")
    List<Comuna> obtenerComunas();

    @Query("SELECT c FROM Comuna c WHERE c.id_comuna = :id_comuna")
    Comuna buscarComuna(int id_comuna);

}
