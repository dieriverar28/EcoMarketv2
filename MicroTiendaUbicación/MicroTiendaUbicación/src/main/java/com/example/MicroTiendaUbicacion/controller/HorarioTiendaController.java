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

import com.example.MicroTiendaUbicacion.modelo.HorarioTienda;
import com.example.MicroTiendaUbicacion.service.HorarioTiendaService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v2/horarios_tienda")
public class HorarioTiendaController {
    @Autowired
        private HorarioTiendaService horarioTiendaService;

        @GetMapping
        public List<HorarioTienda> listarHorariosTienda(){
            return horarioTiendaService.getHorarioTienda();
        }

    //agregar
    @PostMapping
    public HorarioTienda agregarHorarioTienda(@Valid @RequestBody HorarioTienda horarioTienda){
        return horarioTiendaService.saveHorarioTienda(horarioTienda);
     }
    //buscar
    @GetMapping("/{id_horario_tienda}")
    public HorarioTienda buscarHorarioTienda(@PathVariable int id_horario_tienda){
           return horarioTiendaService.getHorarioTiendaById(id_horario_tienda); 
        }
    //actualizar
    @PutMapping("/{id_horario_tienda}")
    public int actualizarHorarioTienda(@PathVariable int id_horario_tienda, @Valid @RequestBody HorarioTienda horarioTienda){
        return horarioTiendaService.updateHorarioTienda(horarioTienda);
    }
    //eliminar
    @DeleteMapping("/{id_horario_tienda}")
    public String eliminarHorarioTienda(@PathVariable int id_horario_tienda){
        if (horarioTiendaService.deleteHorarioTienda(id_horario_tienda)== 1) {
            return "Horario de tienda eliminado correctamente";
        }
        return "Error al eliminar el horario de tienda";
     }

}
