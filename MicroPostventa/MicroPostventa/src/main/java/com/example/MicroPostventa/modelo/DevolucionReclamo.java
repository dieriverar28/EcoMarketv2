package com.example.MicroPostventa.modelo;

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
@Table(name="devolucionreclamo") //la tabla nombre persona
@Data //antes de data ahora va lo de arriba
@AllArgsConstructor
@NoArgsConstructor

public class DevolucionReclamo {
    @Id
    private int id_devolucion;
    @ManyToOne
    @JoinColumn(name="id_venta", nullable=false)
    private Venta venta;
    @ManyToOne
    @JoinColumn(name="id_cliente", nullable=false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name="id_producto", nullable=false)
    private Producto producto;
    @Column(name="motivo", nullable=false)
    private String motivo;
    @Column(name="estado", nullable=false)
    private boolean estado;
    @Column(name="fecha", nullable=false)
    private Date fecha;

}
