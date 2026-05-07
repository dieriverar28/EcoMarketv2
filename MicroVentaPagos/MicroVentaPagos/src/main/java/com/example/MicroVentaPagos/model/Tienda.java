package com.example.MicroVentaPagos.modelo;

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
@Table(name="tienda") //la tabla nombre persona
@Data
@AllArgsConstructor
@NoArgsConstructor
    
public class Tienda {
    @Id
    private int id_tienda;
    @Column(name="nombre", nullable=false)
    private String nombre;
    @Column(name="direccion", nullable=false)
    private String direccion;
    @ManyToOne
    @JoinColumn(name="id_comuna", nullable=false)
    private Comuna comuna;
    @ManyToOne
    @JoinColumn(name="id_region", nullable=false)
    private Region region;
}
