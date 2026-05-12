package com.example.MicroVentaPagos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketSPA.model.Tienda;
import com.example.EcoMarketSPA.repository.TiendaRepository;

import jakarta.transaction.Transactional;




@Service
@Transactional
public class TiendaService {
    @Autowired
    private TiendaRepository tiendaRepository;
    //obtener
    public List<Tienda> getTiendas(){
        return tiendaRepository.obtenerTienda();
    }
    //bucar
    public Tienda getTienda(int id_tienda){
        Tienda tienda = tiendaRepository.buscarTienda(id_tienda);
        if (tienda!=null) {
            return tienda;
        }else
        return new Tienda();
    }
    //eliminar
    public int deleteTienda(int id_tienda){
        tiendaRepository.deleteById(id_tienda);
        return 1;
    }
    //buardar
    public Tienda saveTienda(Tienda tienda){
        return tiendaRepository.save(tienda);
    }
    //modificar
    public Tienda updateTienda(int id_tienda, Tienda tienda){
        Tienda tiendaExistente = getTienda(id_tienda);
        if (tiendaExistente != null && tiendaExistente.getId_tienda() != 0) {
            tienda.setId_tienda(id_tienda);
            return tiendaRepository.save(tienda);
        }
        return null;
    }


}
