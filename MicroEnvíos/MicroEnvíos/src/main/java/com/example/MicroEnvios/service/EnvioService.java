package com.example.MicroEnvios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketSPA.model.Envio;
import com.example.EcoMarketSPA.repository.EnvioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EnvioService {
    @Autowired
//LLAMAR REPOSITORIO
    private EnvioRepository envioRepository;

    //OBTENER TODOS
    public List<Envio> getEnvios(){
        return envioRepository.obtenerEnvios();
    }

    //BUSCAR X id_envio
    public Envio getEnvio(int id_envio){
        Envio envios = envioRepository.buscarEnvio(id_envio);
        if (envios!=null) {
        return envios;
        }else
        return new Envio();
    }

    // ELIMINAR POR ID
    public int deleteEnvio(int id_envio) {
        envioRepository.delete(getEnvio(id_envio));
        return 1;
    }

    // GUARDAR envio
    public Envio saveCupon(Envio envio) {
        return envioRepository.save(envio);
    }

    // MODIFICAR envio
    public int updateEnvio(Envio envio) {
        envioRepository.save(envio);
        return 1;
    }

}
