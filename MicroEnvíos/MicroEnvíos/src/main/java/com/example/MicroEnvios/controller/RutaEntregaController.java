package com.example.MicroEnvios.controller;

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

import com.example.EcoMarketSPA.model.RutaEntrega;
import com.example.EcoMarketSPA.service.RutaEntregaService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping ("api/v2/rutas_entrega")
public class RutaEntregaController {
    @Autowired
    private RutaEntregaService rutaEntregaService;

     @GetMapping
    public List<RutaEntrega> listarRutasEntrega(){
        return rutaEntregaService.getRutaEntregas();
    }
     //agregar
     @PostMapping
    public RutaEntrega agregarRutaEntrega(@Valid @RequestBody RutaEntrega rutaEntrega){
        return rutaEntregaService.saveRutaEntrega(rutaEntrega);
     }
    //buscar
    @GetMapping("/{id_ruta_entrega}")
    public RutaEntrega buscarRutaEntrega(@PathVariable int id_ruta_entrega){
        return rutaEntregaService.getRutaEntrega(id_ruta_entrega);
    }
    //actualizar
    @PutMapping("/{id_ruta_entrega}")
    public RutaEntrega actualizarRutaEntrega(@PathVariable int id_ruta_entrega, @Valid @RequestBody RutaEntrega rutaEntrega){
        return rutaEntregaService.updateRutaEntrega(id_ruta_entrega, rutaEntrega);
    }
    //eliminar
    @DeleteMapping("/{id_ruta_entrega}")
    public String eliminarRutaEntrega(@PathVariable int id_ruta_entrega){
        if (rutaEntregaService.deleteRutaEntrega(id_ruta_entrega)== 1) {
            return "Ruta de entrega eliminada correctamente";
        }
        return "Error al eliminar la ruta de entrega";
    }

}
