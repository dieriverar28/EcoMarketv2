package com.example.MicroVentaPagos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.MicroVentaPagos.modelo.Boleta;
import com.example.MicroVentaPagos.service.BoletaService;

import jakarta.validation.Valid;

public class BoletaController {
    @Autowired
    private BoletaService boletaService;

    @GetMapping
    public List<Boleta> listarBoleta(){
        return boletaService.getBoletas();
    } 

    @PostMapping
    public Boleta agregarBoleta(@Valid @RequestBody Boleta boleta) {
        return boletaService.saveBoletas(boleta);
    }

    @GetMapping("{id_boleta}")
    public Boleta buscarBoleta(@PathVariable int id_boleta) {
        return boletaService.getBoletaById(id_boleta);
    }
    
    @PutMapping("{id_boleta}")
    public int actualizarBoleta(@PathVariable int id_boleta, @Valid @RequestBody Boleta boleta) {
        return boletaService.updateBoleta(boleta);
    }
    
    @DeleteMapping("{id_boleta}")
    public String eliminarBoleta(@PathVariable int id_boleta) {
        if (boletaService.deleteBoleta(id_boleta)==1) {
            return "boleta eliminada";
        } 
        return "error al eliminar boleta";
    }

}
