package com.example.MicroPostventa.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroPostventa.modelo.DevolucionReclamo;
import com.example.MicroPostventa.repository.DevolucionReclamoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DevolucionReclamoService {
    @Autowired
//LLAMAR REPOSITORIO
    private DevolucionReclamoRepository devolucionReclamoRepository;
//OBTENER TODOS
    public List<DevolucionReclamo> getDevolucionReclamos() {
        return devolucionReclamoRepository.obtenerDevolucionReclamos();
    }   
//OBTENER POR ID
    public DevolucionReclamo getDevolucionReclamoById(int id_devolucion) {
        DevolucionReclamo devolucion = devolucionReclamoRepository.busDevolucionReclamo(id_devolucion);
        if (devolucion!=null) {
        return devolucion;
        }else
        return new DevolucionReclamo();
    }
//CREAR DevolucionReclamo
    public DevolucionReclamo saveDevolucionReclamo(DevolucionReclamo devolucion) {
        return devolucionReclamoRepository.save(devolucion);
    }
//ACTUALIZAR DevolucionReclamo
    public int updateDevolucionReclamo(DevolucionReclamo devolucion) {
        devolucionReclamoRepository.save(devolucion);
        return 1;
    }   
//ELIMINAR DevolucionReclamo
    public int deleteDevolucionReclamo(int id_devolucion) {
        devolucionReclamoRepository.delete(getDevolucionReclamoById(id_devolucion));
        return 1;
    }      
//MODIFICAR ESTADO DE DevolucionReclamo
    public int PostularDevolucionReclamo(DevolucionReclamo devolucion) {
        devolucionReclamoRepository.save(devolucion);
        return 1;
    }

}
