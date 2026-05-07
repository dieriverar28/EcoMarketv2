package com.example.MicroProducto.controller;

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

import com.example.MicroProducto.model.Proveedor;
import com.example.MicroProducto.service.ProveedorService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v2/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> listarProveedores(){
        return proveedorService.getProveedores();
    }
    //agregar
    @PostMapping
    public Proveedor agregarProveedor(@Valid @RequestBody Proveedor proveedor){
        return proveedorService.saveProveedor(proveedor);
     }
    //buscar
        @GetMapping("/{id_proveedor}")
        public Proveedor buscarProveedor(@PathVariable int id_proveedor){
            return proveedorService.getProveedor(id_proveedor);
        }
    //actualizar
    @PutMapping("/{id_proveedor}")
    public Proveedor actualizarProveedor(@PathVariable int id_proveedor, @Valid @RequestBody Proveedor proveedor){
        return proveedorService.updateProveedor(id_proveedor, proveedor);
    }
    //eliminar
    @DeleteMapping("/{id_proveedor}")
    public String eliminarProveedor(@PathVariable int id_proveedor){
        if (proveedorService.deleteProveedor(id_proveedor)== 1) {
            return "Proveedor eliminado correctamente";
        }
        return "Error al eliminar el proveedor";
    }

}
