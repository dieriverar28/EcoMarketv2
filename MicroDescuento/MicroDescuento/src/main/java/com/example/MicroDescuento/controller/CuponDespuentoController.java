package com.example.MicroDescuento.controller;

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

import com.example.EcoMarketSPA.model.CuponDescuento;
import com.example.EcoMarketSPA.service.CuponDescuentoService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v2/cupones_descuento")
public class CuponDespuentoController {
    @Autowired
    private CuponDescuentoService cuponDescuentoService;

    @GetMapping
    public List<CuponDescuento> listarCuponDescuentos(){
        return cuponDescuentoService.getAllCupones();
    }

    //agregar
    @PostMapping
    public CuponDescuento agregarCuponDescuento(@Valid @RequestBody CuponDescuento cuponDescuento){
        return cuponDescuentoService.saveCuponDescuento(cuponDescuento);
    }
    //buscar
    @GetMapping("{id_cupon_descuento}")
    public CuponDescuento buscarCuponDescuento(@PathVariable int id_cupon_descuento){
        return cuponDescuentoService.getCuponDescuentoById(id_cupon_descuento);
    }
    //actualizar
    @PutMapping("{id_cupon_descuento}")
    public int actualizarCuponDescuento(@PathVariable int id_cupon_descuento, @Valid @RequestBody CuponDescuento cuponDescuento){
        return cuponDescuentoService.updateCuponDescuento(cuponDescuento);
    }
    //eliminar
    @DeleteMapping("{id_cupon_descuento}")
    public String eliminarCuponDescuento(@PathVariable int id_cupon_descuento){
        if (cuponDescuentoService.deleteCuponDescuento(id_cupon_descuento)==1){
            return "Cupon de descuento eliminado correctamente";
        }
        return "Error al eliminar el cupon de descuento";
    }
}
