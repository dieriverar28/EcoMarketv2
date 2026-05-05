package com.example.MicroVentaPagos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MicroVentaPagos.modelo.Boleta;

//import com.example.EcoMarketSPA.model.Boleta;


@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
    
    @Query("SELECT b FROM Boleta b")
    List<Boleta> obtenerBoletas();

    @Query("SELECT b FROM Boleta b WHERE b.id_boleta = :id_boleta")
    Boleta buscarBoleta(int id_boleta);


}
