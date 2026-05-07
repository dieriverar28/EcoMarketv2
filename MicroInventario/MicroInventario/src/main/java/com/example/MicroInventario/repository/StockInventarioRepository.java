package com.example.MicroInventario.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.EcoMarketSPA.model.StockInventario;

@Repository
public class StockInventarioRepository {
    @Query("SELECT s FROM StockInventario s")
    List<StockInventario> obtenerStockInventario();

    @Query("SELECT s FROM StockInventario s WHERE s.id_stock = :id_stock")
    StockInventario buscarStockInventario(int id_stock);

}
