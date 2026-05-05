package com.example.MicroTiendaUbicacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroTiendaUbicacion.modelo.HorarioTienda;
import com.example.MicroTiendaUbicacion.repository.HorarioTiendaRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class HorarioTiendaService {
    @Autowired
    //
    private HorarioTiendaRepository horarioTiendaRepository;
    
    //obtenre todos
    public List<HorarioTienda> getHorarioTienda(){
        return horarioTiendaRepository.obtenerHorarioTiendas();
    }
    //buscar por id 
    public HorarioTienda getHorarioTiendaById(int id_horario_tienda){
        HorarioTienda horarioTienda = horarioTiendaRepository.buscarHorarioTienda(id_horario_tienda);
        if (horarioTienda != null) {
            return horarioTienda;
        } else {
            return new HorarioTienda();
        }
    }
    //eliminar por id
    public int deleteHorarioTienda(int id_horario_tienda){
        horarioTiendaRepository.delete(getHorarioTiendaById(id_horario_tienda));
        return 1;
    }
    //guardadr por id 
    public HorarioTienda saveHorarioTienda(HorarioTienda horariotienda){
        return horarioTiendaRepository.save(horariotienda);
    }
    //modificar por id 
    public int  updateHorarioTienda(HorarioTienda horario){
       horarioTiendaRepository.save(horario);
       return 1;
    }

}
