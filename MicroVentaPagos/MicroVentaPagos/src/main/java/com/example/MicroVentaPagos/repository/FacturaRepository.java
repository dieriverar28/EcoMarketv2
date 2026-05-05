package com.example.MicroVentaPagos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MicroVentaPagos.modelo.Factura;

//import com.example.EcoMarketSPA.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    
 @Query("SELECT f FROM Factura f")
    List<Factura> obtenerCuponDescuentos();

    @Query("SELECT f FROM Factura f WHERE f.id_factura = :id_factura")
    Factura buscarFactura(int id_factura);


}
