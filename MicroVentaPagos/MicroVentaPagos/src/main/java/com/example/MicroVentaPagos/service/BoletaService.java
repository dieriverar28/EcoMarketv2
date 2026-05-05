package com.example.MicroVentaPagos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroVentaPagos.modelo.Boleta;
import com.example.MicroVentaPagos.repository.BoletaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BoletaService {
    @Autowired
//SE LLAMA AL REPOSITORIO PARA PODER USAR SUS FUNCIONES
    private BoletaRepository boletaRepository; 

//OBTENER TODAS LAS BOLETAS
    public List<Boleta> getBoletas() {
        return boletaRepository.obtenerBoletas();
    }
//OBTENER BOLETA POR ID
    public Boleta getBoletaById(int id_boleta) {
        Boleta boletas = boletaRepository.buscarBoleta(id_boleta);
        if (boletas!=null) {
        return boletas;
        }else
        return new Boleta();
    
    }
//CREAR BOLETA
    public Boleta saveBoletas(Boleta boleta) {
        return boletaRepository.save(boleta);
    }
//ACTUALIZAR BOLETA
    public int updateBoleta(Boleta boleta) {
         boletaRepository.save(boleta);
        return 1;
    }
//ELIMINAR BOLETA
    public int deleteBoleta(int id_boleta) {
        boletaRepository.delete(getBoletaById(id_boleta));
        return 1;
    }


}
