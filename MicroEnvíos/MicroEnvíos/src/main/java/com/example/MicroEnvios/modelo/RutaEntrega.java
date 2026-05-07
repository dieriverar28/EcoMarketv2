package com.example.MicroEnvios.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //se conecta con entidad
@Table(name="rutaentrega") //la tabla nombre persona
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RutaEntrega {
    @Id
    private int id_ruta;//pk
    @Column(name="nombre",nullable=false)
    private String nombre;
    @Column(name="descripcion",nullable=false)
    private String descripcion;
    @Column(name="tipo",nullable=false)
    private String tipo;

}
