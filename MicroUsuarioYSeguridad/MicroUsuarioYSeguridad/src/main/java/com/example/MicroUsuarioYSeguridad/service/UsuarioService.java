package com.example.MicroUsuarioYSeguridad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroUsuarioYSeguridad.modelo.Usuario;
import com.example.MicroUsuarioYSeguridad.repository.UsuarioRepository;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class UsuarioService {
    @Autowired

    private UsuarioRepository usuarioRepository;
    //obtener
    public List<Usuario> getUsuarios(){
        return usuarioRepository.obtenerUsuario();
    }
    //obtener sin parámetros (para compatibilidad con controlador)
    public List<Usuario> getUsuario(){
        return usuarioRepository.obtenerUsuario();
    }
    //bucar
    public Usuario getUsuario(int id_usuario){
        Usuario usuarios = usuarioRepository.buscarUsuario(id_usuario);
        if (usuarios!=null) {
        return usuarios;
        }else
        return new Usuario();
    }
    //eliminar
    public int deleteUsuario(int id_usuario){
        usuarioRepository.deleteById(id_usuario);
        return 1;
    }
    //buardar
    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    //modificar
    public Usuario updateUsuario(int id_usuario, Usuario usuario){
        Usuario usuarioExistente = getUsuario(id_usuario);
        if (usuarioExistente != null && usuarioExistente.getId_usuario() != 0) {
            usuario.setId_usuario(id_usuario);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

}
