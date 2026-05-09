package com.example.MicroInventario.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //se conecta con entidad
@Table(name="producto") //la tabla nombre persona
@Data //antes de data ahora va lo de arriba
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
     @Id
    private int id_producto; //pk
    @Column(name="nombre", nullable =false)
    private String nombre;
    private String  descripcion;
    @Column(name="categoria", nullable =false)
    private String categoria;
    @Column(name="precio_base", nullable =false)
    private int precio_base;
    @Column(name="estado", nullable =false)
    private boolean estado;

}
