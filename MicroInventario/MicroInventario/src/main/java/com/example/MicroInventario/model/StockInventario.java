package com.example.MicroInventario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="stockinventario")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class StockInventario {

    @Id
    private int id_stock;

    @ManyToOne
    @JoinColumn(name="id_tienda", nullable=false)
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name="id_producto", nullable=false)
    private Producto producto;

    @Column(name="cantidad", nullable=false)
    private int cantidad;

    @Column(name="stock_min")
    private int stock_min;
}