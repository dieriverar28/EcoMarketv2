package com.example.MicroInventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MicroInventario.model.StockInventario;

@Repository

public interface StockInventarioRepository
        extends JpaRepository<StockInventario, Integer> {

    @Query("SELECT s FROM StockInventario s")
    List<StockInventario> obtenerStockInventario();

    @Query("SELECT s FROM StockInventario s WHERE s.id_stock = :id_stock")
    StockInventario buscarStockInventario(int id_stock);

}