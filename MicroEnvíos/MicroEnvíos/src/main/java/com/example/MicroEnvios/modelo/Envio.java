package com.example.MicroEnvios.modelo;

import java.sql.Date;

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
@Table(name="envio") //la tabla nombre persona
@Data //antes de data ahora va lo de arriba
@AllArgsConstructor
@NoArgsConstructor

public class Envio {
    @Id
    private int id_envio;
    @ManyToOne
    @JoinColumn(name="id_venta", nullable=false)
    private Venta venta;
    @ManyToOne
    @JoinColumn(name="id_cliente", nullable=false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name="id_provedor", nullable=false)
    private Proveedor provedor;
    @ManyToOne
    @JoinColumn(name="id_ruta", nullable=false)
    private RutaEntrega ruta;
    private boolean estado;
    @Column(name="fecha_despacho", nullable=false)
    private Date fecha_despacho;
    @Column(name="fecha_entrega_est", nullable=false)
    private Date fecha_entrega_est;

}
