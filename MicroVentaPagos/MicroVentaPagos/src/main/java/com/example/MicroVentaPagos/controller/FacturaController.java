package com.example.MicroVentaPagos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MicroVentaPagos.modelo.Factura;

import com.example.MicroVentaPagos.service.FacturaService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v1/facturas")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> listarFacturas(){
        return facturaService.getFacturas();
    }

    //agregar
    @PostMapping
    public Factura agregarFactura(@Valid @RequestBody Factura factura){
        return facturaService.saveFactura(factura);
     }
    //buscar
     @GetMapping("/{id_factura}")
     public Factura buscarFactura(@PathVariable int id_factura){
        return facturaService.getFactura(id_factura);
     }
    //actualizar
    @PutMapping("/{id_factura}")
    public int actualizarFactura(@PathVariable int id_factura, @Valid @RequestBody Factura factura){
        return facturaService.updateFactura(factura);
     }
    //eliminar
    @DeleteMapping("/{id_factura}")
    public String eliminarFactura(@PathVariable int id_factura){
        if (facturaService.deleteFactura(id_factura)== 1) {
            return "Factura eliminada correctamente";
        }
        return "Error al eliminar la factura";
     }



}
