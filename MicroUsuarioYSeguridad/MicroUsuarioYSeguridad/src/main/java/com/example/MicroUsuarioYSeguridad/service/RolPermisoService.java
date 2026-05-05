package com.example.MicroUsuarioYSeguridad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketSPA.model.RolPermiso;
import com.example.EcoMarketSPA.repository.RolPermisoRepository;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class RolPermisoService {
    @Autowired
    private RolPermisoRepository rolPermisoRepository;

    //obtener
    public List<RolPermiso> getRolPermisos(){
        return rolPermisoRepository.obtenerRolPermiso();
    }
    //bucar
    public RolPermiso getRolPermiso(int id_rol_permiso){
        RolPermiso rolPermiso = rolPermisoRepository.buscarRolPermiso(id_rol_permiso);
        if (rolPermiso != null) {
            return rolPermiso;
        } else {
            return new RolPermiso();
        }
    }
    //eliminar
    public int deleteRolPermiso(int id_rol_permiso){
        rolPermisoRepository.deleteById(id_rol_permiso);
        return 1;
    }
    //guardar
    public RolPermiso saveRolPermiso(RolPermiso rolPermiso){
        return rolPermisoRepository.save(rolPermiso);
    }
    //modificar
    public RolPermiso updateRolPermiso(int id_rol_permiso, RolPermiso rolPermiso){
        RolPermiso rolPermisoExistente = getRolPermiso(id_rol_permiso);
        if (rolPermisoExistente != null && rolPermisoExistente.getId_rol() != 0) {
            rolPermiso.setId_rol(id_rol_permiso);
            return rolPermisoRepository.save(rolPermiso);
        }
        return null;
    }

}
