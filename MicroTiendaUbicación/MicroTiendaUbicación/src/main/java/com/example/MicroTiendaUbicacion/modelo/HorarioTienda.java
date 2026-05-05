package com.example.MicroTiendaUbicacion.modelo;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //se conecta con entidad
@Table(name="horariotienda") //la tabla nombre persona
@Data //antes de data ahora va lo de arriba
@AllArgsConstructor
@NoArgsConstructor

public class HorarioTienda {
    @Id
    private int id_horario;
    @ManyToOne
    @JoinColumn(name="id_tienda", nullable=false)
    private Tienda tienda;
    @Column(name="dia_semana", nullable=false)
    private String dia_semana;
    private Time hora_apertura;
    private Time hora_cierre;
    

}
