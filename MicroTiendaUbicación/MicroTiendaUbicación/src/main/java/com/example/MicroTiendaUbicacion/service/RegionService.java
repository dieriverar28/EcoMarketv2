package com.example.MicroTiendaUbicacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroTiendaUbicacion.modelo.Region;
import com.example.MicroTiendaUbicacion.repository.RegionRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    //obtener
    public List<Region> getRegiones(){
        return regionRepository.obtenerRegiones();
    }
    //bucar
    public Region getRegion(int id_region){
        Region regiones = regionRepository.buscarRegion(id_region);
        if (regiones!=null) {
        return regiones;
        }else
        return new Region();
    }
    //eliminar
    public int deleteRegion(int id_region){
        regionRepository.deleteById(id_region);
        return 1;
    }
    //guardar
    public Region saveRegion(Region region){
        return regionRepository.save(region);
    }
    //modificar
    public Region updateRegion(int id_region, Region region){
        Region regionExistente = getRegion(id_region);
        if (regionExistente != null && regionExistente.getId_region() != 0) {
            region.setId_region(id_region);
            return regionRepository.save(region);
        }
        return null;
    }

}
