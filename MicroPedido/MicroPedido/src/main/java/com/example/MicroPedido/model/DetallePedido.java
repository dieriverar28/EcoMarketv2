package com.example.MicroPedido.modelo;

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
@Table(name="detallepedido") //la tabla nombre persona
@Data //antes de data ahora va lo de arriba
@AllArgsConstructor
@NoArgsConstructor



public class DetallePedido {
    @Id
    private int id_detalle;
    @ManyToOne
    @JoinColumn(name="id_pedido", nullable=false)
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name="id_producto", nullable=false)
    private Producto producto;
    @Column(name="cantidad", nullable=false)
    private int cantidad;
    @Column(name="precio_unitario", nullable=false)
    private int precio_unitario;

}
