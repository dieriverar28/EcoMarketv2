package com.example.MicroInventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.MicroInventario.model.StockInventario;
import com.example.MicroInventario.service.StockInventarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v2/stock_inventarios")

public class StockInventarioController {

    @Autowired
    private StockInventarioService stockInventarioService;

    @GetMapping
    public List<StockInventario> listarStockInventarios() {

        return stockInventarioService.getStockInventarios();
    }

    // agregar
    @PostMapping
    public StockInventario agregarStockInventario(
            @Valid @RequestBody StockInventario stockInventario) {

        return stockInventarioService.saveStockInventario(stockInventario);
    }

    // buscar
    @GetMapping("/{id_stock_inventario}")
    public StockInventario buscarStockInventario(
            @PathVariable int id_stock_inventario) {

        return stockInventarioService.getStockInventario(id_stock_inventario);
    }

    // actualizar
    @PutMapping("/{id_stock_inventario}")
    public int actualizarStockInventario(
            @PathVariable int id_stock_inventario,
            @Valid @RequestBody StockInventario stockInventario) {

        return stockInventarioService.updateStockInventario(stockInventario);
    }

    // eliminar
    @DeleteMapping("/{id_stock_inventario}")
    public String eliminarStockInventario(
            @PathVariable int id_stock_inventario) {

        if (stockInventarioService.deleteStockInventario(id_stock_inventario) == 1) {

            return "StockInventario eliminado correctamente";
        }

        return "Error al eliminar el stock_inventario";
    }
}