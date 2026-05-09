package com.example.MicroEnvios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketSPA.model.RutaEntrega;
import com.example.EcoMarketSPA.repository.RutaEntregaRepository;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class RutaEntregaService {
    @Autowired
    private RutaEntregaRepository rutaEntregaRepository;
    //obtener
    public List<RutaEntrega> getRutaEntregas(){
        return rutaEntregaRepository.obtenerRutaEntrega();
    }
    //bucar
    public RutaEntrega getRutaEntrega(int id_ruta_entrega){
        RutaEntrega rutaEntregas = rutaEntregaRepository.buscarRutaEntrega(id_ruta_entrega);
        if (rutaEntregas!=null) {
            return rutaEntregas;
        }else
        return new RutaEntrega();
    }
    //eliminar
    public int deleteRutaEntrega(int id_ruta_entrega){
        rutaEntregaRepository.deleteById(id_ruta_entrega);
        return 1;
    }
    //buardar
    public RutaEntrega saveRutaEntrega(RutaEntrega rutaEntrega){
        return rutaEntregaRepository.save(rutaEntrega);
    }
    //modificar
    public RutaEntrega updateRutaEntrega(int id_ruta_entrega, RutaEntrega rutaEntrega){
        RutaEntrega rutaExistente = getRutaEntrega(id_ruta_entrega);
        if (rutaExistente != null && rutaExistente.getId_ruta() != 0) {
            rutaEntrega.setId_ruta(id_ruta_entrega);
            return rutaEntregaRepository.save(rutaEntrega);
        }
        return null;
    }

}
