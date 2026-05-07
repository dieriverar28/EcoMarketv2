package com.example.MicroVentaPagos.model;

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
@Table(name="venta") //la tabla nombre persona
//@Data //antes de data ahora va lo de arriba
//@AllArgsConstructor
@NoArgsConstructor

public class Venta {
    @Id
    private int id_venta;
    @ManyToOne
    @JoinColumn(name="id_pedido", nullable=false)
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name="id_tienda", nullable=false)
    private Tienda tienda;
    @ManyToOne
    @JoinColumn(name="id_cliente", nullable=false)
    private Cliente cliente;
    private Date fecha_venta;
    private int total_neto;
    private int descuento_aplicado;
    private String tipo_documento;

}
