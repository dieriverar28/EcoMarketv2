package com.example.MicroTiendaUbicacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MicroTiendaUbicacion.modelo.Region;


@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    
    @Query("SELECT r FROM Region r")
    List<Region> obtenerRegiones();

    @Query("SELECT r FROM Region r WHERE r.id_region = :id_region")
    Region buscarRegion(int id_region);

}
