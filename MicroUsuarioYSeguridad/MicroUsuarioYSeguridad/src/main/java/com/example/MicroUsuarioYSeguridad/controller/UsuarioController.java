package com.example.MicroUsuarioYSeguridad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcoMarketSPA.model.Usuario;
import com.example.EcoMarketSPA.service.UsuarioService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v2/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.getUsuario();
    }
     //agregar
    @PostMapping
    public Usuario agregarUsuario(@Valid @RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
     }
    //buscar
    @GetMapping("/{id_usuario}")
    public Usuario buscarUsuario(@PathVariable int id_usuario){
        return usuarioService.getUsuario(id_usuario);
    }
    //actualizar
    @PutMapping("/{id_usuario}")
    public Usuario actualizarUsuario(@PathVariable int id_usuario, @Valid @RequestBody Usuario usuario){
        return usuarioService.updateUsuario(id_usuario, usuario);
    }
    //eliminar
    @DeleteMapping("/{id_usuario}")
    public String eliminarUsuario(@PathVariable int id_usuario){
        if (usuarioService.deleteUsuario(id_usuario) == 1) {
            return "Usuario eliminado correctamente";
        }
        return "Error al eliminar el usuario";
    }

}
