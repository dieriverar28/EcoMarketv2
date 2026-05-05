package com.example.MicroUsuarioYSeguridad.controller;

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

import com.example.EcoMarketSPA.model.RolPermiso;
import com.example.EcoMarketSPA.service.RolPermisoService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping ("api/v2/roles_permisos")
public class RolPermisoController {
    @Autowired
    private RolPermisoService rolPermisoService;

    @GetMapping
    public List<RolPermiso> listarRolesPermisos(){
        return rolPermisoService.getRolPermisos();
    }
    //agregar
    @PostMapping
    public RolPermiso agregarRolPermiso(@Valid @RequestBody RolPermiso rolPermiso){
        return rolPermisoService.saveRolPermiso(rolPermiso);
    }

    //buscar
    @GetMapping("/{id_rol_permiso}")
    public RolPermiso buscarRolPermiso(@PathVariable int id_rol_permiso){
        return rolPermisoService.getRolPermiso(id_rol_permiso);
    }

    //actualizar
    @PutMapping("/{id_rol_permiso}")
    public RolPermiso actualizarRolPermiso(@PathVariable int id_rol_permiso, @Valid @RequestBody RolPermiso rolPermiso){
        return rolPermisoService.updateRolPermiso(id_rol_permiso, rolPermiso);
    }
    //eliminar
    @DeleteMapping("/{id_rol_permiso}")
    public String eliminarRolPermiso(@PathVariable int id_rol_permiso){
        if (rolPermisoService.deleteRolPermiso(id_rol_permiso)== 1) {
            return "Rol de permiso eliminado correctamente";
        }
        return "Error al eliminar el rol de permiso";
    }

}
