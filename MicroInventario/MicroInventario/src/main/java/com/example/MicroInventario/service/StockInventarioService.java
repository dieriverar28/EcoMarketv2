package com.example.MicroInventario.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketSPA.model.StockInventario;
import com.example.EcoMarketSPA.repository.StockInventarioRepository;

import jakarta.transaction.Transactional;




@Service
@Transactional
public class StockInventarioService {
    @Autowired
    private StockInventarioRepository stockInventarioRepository;
    //obtener
    public List<StockInventario> getStockInventarios(){
        return stockInventarioRepository.obtenerStockInventario();
    } 
    //bucar
    public StockInventario getStockInventario(int id_stock_inventario){
        StockInventario stockInventarios = stockInventarioRepository.buscarStockInventario(id_stock_inventario);
        if (stockInventarios!=null) {
        return stockInventarios;
        }else
        return new StockInventario();
    }
    //eliminar
    public int deleteStockInventario(int id_stock_inventario){
        stockInventarioRepository.deleteById(id_stock_inventario);
        return 1;
    }
    //buardar
    public StockInventario saveStockInventario(StockInventario stockInventario){
        return stockInventarioRepository.save(stockInventario);
    }
    //modificar
    public int updateStockInventario(StockInventario stockInventario){
        stockInventarioRepository.save(stockInventario);
        return 1;
    }


}
