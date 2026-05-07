package com.example.MicroUsuarioYSeguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MicroUsuarioYSeguridad.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    @Query("SELECT u FROM Usuario u")
    List<Usuario> obtenerUsuario();

    @Query("SELECT u FROM Usuario u WHERE u.id_usuario = :id_usuario")
    Usuario buscarUsuario(int id_usuario);

}
