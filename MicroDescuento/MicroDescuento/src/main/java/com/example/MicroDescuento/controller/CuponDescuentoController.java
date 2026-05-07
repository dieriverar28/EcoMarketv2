package com.example.MicroDescuento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.MicroDescuento.model.CuponDescuento;
import com.example.MicroDescuento.service.CuponDescuentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v2/cupones_descuento")

public class CuponDescuentoController {

    @Autowired
    private CuponDescuentoService cuponDescuentoService;

    @GetMapping
    public List<CuponDescuento> listarCuponDescuentos() {
        return cuponDescuentoService.getAllCupones();
    }

    // agregar
    @PostMapping
    public CuponDescuento agregarCuponDescuento(
            @Valid @RequestBody CuponDescuento cuponDescuento) {

        return cuponDescuentoService.saveCuponDescuento(cuponDescuento);
    }

    // buscar
    @GetMapping("{id_cupon_descuento}")
    public CuponDescuento buscarCuponDescuento(
            @PathVariable int id_cupon_descuento) {

        return cuponDescuentoService.getCuponDescuentoById(id_cupon_descuento);
    }

    // actualizar
    @PutMapping("{id_cupon_descuento}")
    public int actualizarCuponDescuento(
            @PathVariable int id_cupon_descuento,
            @Valid @RequestBody CuponDescuento cuponDescuento) {

        return cuponDescuentoService.updateCuponDescuento(cuponDescuento);
    }

    // eliminar
    @DeleteMapping("{id_cupon_descuento}")
    public String eliminarCuponDescuento(
            @PathVariable int id_cupon_descuento) {

        if (cuponDescuentoService.deleteCuponDescuento(id_cupon_descuento) == 1) {
            return "Cupon de descuento eliminado correctamente";
        }

        return "Error al eliminar el cupon de descuento";
    }
}