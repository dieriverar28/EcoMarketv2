package com.example.MicroTiendaUbicacion.controller;

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

import com.example.MicroTiendaUbicacion.modelo.Region;
import com.example.MicroTiendaUbicacion.service.RegionService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v2/regiones")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping
    public List<Region> listarRegiones(){
        return regionService.getRegiones();
    }

    //agregar
    @PostMapping
    public Region agregarRegion(@Valid @RequestBody Region region){
        return regionService.saveRegion(region);
    }

    //buscar
    @GetMapping("/{id_region}")
    public Region buscarRegion(@PathVariable int id_region){
        return regionService.getRegion(id_region);
    }

    //actualizar
    @PutMapping("/{id_region}")
    public Region actualizarRegion(@PathVariable int id_region, @Valid @RequestBody Region region){
        return regionService.updateRegion(id_region, region);
    }

    //eliminar
    @DeleteMapping("/{id_region}")
    public String eliminarRegion(@PathVariable int id_region){
        if (regionService.deleteRegion(id_region)== 1) {
            return "Región eliminada correctamente";
        }
        return "Error al eliminar la región";
    }

}
