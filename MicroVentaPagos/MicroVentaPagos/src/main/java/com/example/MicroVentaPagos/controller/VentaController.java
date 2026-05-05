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

import com.example.MicroVentaPagos.modelo.Venta;
import com.example.MicroVentaPagos.service.VentaService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v2/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> listarVentas(){
        return ventaService.getVentas();
    }

     //agregar
     @PostMapping
        public Venta agregarVenta(@Valid @RequestBody Venta venta){
            return ventaService.saveVenta(venta);
        }
    //buscar
    @GetMapping("/{id_venta}")
    public Venta buscarVenta(@PathVariable int id_venta){
        return ventaService.getVenta(id_venta);
    }
    //actualizar
    @PutMapping("/{id_venta}")
    public int actualizarVenta(@PathVariable int id_venta, @Valid @RequestBody Venta venta){
        return ventaService.updateVenta(venta);
    }
    //eliminar
    @DeleteMapping("/{id_venta}")
    public String eliminarVenta(@PathVariable int id_venta){
        if (ventaService.deleteVenta(id_venta)== 1) {
            return "Venta eliminada correctamente";
        }
        return "Error al eliminar la venta";
     }


}
