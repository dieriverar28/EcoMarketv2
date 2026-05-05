package com.example.MicroUsuarioYSeguridad.modelo;
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
@Table(name="usuario") //la tabla nombre persona
@Data
@AllArgsConstructor
@NoArgsConstructor

//con genero normalizado
public class Usuario {
    @Id
    private int id_usuario;
    @ManyToOne
    @JoinColumn(name="id_genero", nullable=false)
    private Genero genero;
    @Column(name="nombre", nullable=false)
    private String nombre;
    @Column(name="email", nullable=false)
    private String email;
    @ManyToOne
    @JoinColumn(name="id_rol", nullable=false)
    private RolPermiso rol;
    @Column(name="id_tienda", nullable=false)
    private int idTienda;
    private boolean estado;

}
