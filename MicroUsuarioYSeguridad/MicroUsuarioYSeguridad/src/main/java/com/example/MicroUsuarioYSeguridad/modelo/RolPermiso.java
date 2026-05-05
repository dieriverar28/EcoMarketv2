package com.example.MicroUsuarioYSeguridad.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //se conecta con entidad
@Table(name="rolpermiso") //la tabla nombre persona
@Data //antes de data ahora va lo de arriba
@AllArgsConstructor
@NoArgsConstructor



public class RolPermiso {
    @Id
    private int id_rol;//pk
    @Column(name="nombre_rol", nullable =false)
    private String nombre_rol;
    @Column(name="modulo", nullable =false)
    private String modulo;
    @Column(name="accion", nullable =false)
    private String accion;

}
