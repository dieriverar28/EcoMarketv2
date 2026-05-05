package com.example.MicroPostventa.Controller;

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

import com.example.MicroPostventa.modelo.DevolucionReclamo;
import com.example.MicroPostventa.service.DevolucionReclamoService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v2/devolucion_reclamos")
public class DevolucionReclamoController {
    @Autowired
    private DevolucionReclamoService devolucionReclamoService;

    @GetMapping
    public List<DevolucionReclamo> listarDevolucionReclamos(){
        return devolucionReclamoService.getDevolucionReclamos();
    }
    //agregar
    @PostMapping
    public DevolucionReclamo agregDevolucionReclamo(@Valid @RequestBody DevolucionReclamo devolucionReclamo){
        return devolucionReclamoService.saveDevolucionReclamo(devolucionReclamo);
    }
    //buscar
    @GetMapping("{id_devolucion_reclamo}")
    public DevolucionReclamo busDevolucionReclamo(@PathVariable int id_devolucion_reclamo){
        return devolucionReclamoService.getDevolucionReclamoById(id_devolucion_reclamo);
    }
    //actualizar
    @PutMapping("{id_devolucion_reclamo}")
    public int actualizarDevolucionReclamo(@PathVariable int id_devolucion_reclamo, @Valid @RequestBody DevolucionReclamo devolucionReclamo){
        return devolucionReclamoService.updateDevolucionReclamo( devolucionReclamo);
    }
    //eliminar
    @DeleteMapping("{id_devolucion_reclamo}")
    public String eliminarDevulucionReclamo(@PathVariable int id_devolucion_reclamo){
        if(devolucionReclamoService.deleteDevolucionReclamo(id_devolucion_reclamo)==1){
            return "Devolucion reclamo eliminado correctamente";
        }
        return "Error al eliminar el devolucion reclamo";
    }

}
