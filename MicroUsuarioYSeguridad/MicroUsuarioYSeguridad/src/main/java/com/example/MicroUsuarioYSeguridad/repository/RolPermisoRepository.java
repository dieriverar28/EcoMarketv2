package com.example.MicroUsuarioYSeguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MicroUsuarioYSeguridad.modelo.RolPermiso;


@Repository
public interface RolPermisoRepository extends JpaRepository<RolPermiso, Integer> {
    @Query("SELECT rp FROM RolPermiso rp")
    List<RolPermiso> obtenerRolPermiso();

    @Query("SELECT rp FROM RolPermiso rp WHERE rp.id_rol = :id_rol")
    RolPermiso buscarRolPermiso(int id_rol);

}
