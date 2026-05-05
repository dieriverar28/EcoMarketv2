package com.example.MicroTiendaUbicacion.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity //se conecta con entidad
@Table(name="region") //la tabla nombre persona
@Data //antes de data ahora va lo de arriba
@AllArgsConstructor
@NoArgsConstructor

public class Region {
    @Id
    private int id_region;
    @Column(name="nombre", nullable =false)
    private String nombre;

}
