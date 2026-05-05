package com.example.MicroVentaPagos.modelo;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //se conecta con entidad
@Table(name="boleta") //la tabla nombre persona
@Data //antes de data ahora va lo de arriba
@AllArgsConstructor
@NoArgsConstructor


public class Boleta {
    @Id
    private int id_boleta;
    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta; //FK
    @Column(name="folio", nullable =false)
    private String folio;
    @Column(name="timbre_electronico", nullable =false)
    private String timbre_electronico;
    @Column(name="nombre_receptor", nullable =false)
    private String nombre_receptor;
    @Column(name="rut_receptor", nullable =false)
    private String rut_receptor;
    private Date fecha_emision;
    private int monto_neto;
    private int monto_iva;
    private int monto_total;
    private String email_envio;
    private boolean anulada;

}
