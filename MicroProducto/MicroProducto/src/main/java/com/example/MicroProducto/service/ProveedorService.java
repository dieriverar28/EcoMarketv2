package com.example.MicroProducto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroProducto.modelo.Proveedor;
import com.example.MicroProducto.repository.ProveedorRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    //obtener
    public List<Proveedor> getProveedores(){
        return proveedorRepository.obtenerProveedor();
    }
    //bucar
    public Proveedor getProveedor(int id_proveedor){
        Proveedor proveedor = proveedorRepository.buscarProveedor(id_proveedor);
        if (proveedor != null) {
            return proveedor;
        } else {
            return new Proveedor();
        }
    }
    //eliminar
    public int deleteProveedor(int id_proveedor){
        proveedorRepository.deleteById(id_proveedor);
        return 1;
    }
    //guardar
    public Proveedor saveProveedor(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }
    //modificar
    public Proveedor updateProveedor(int id_proveedor, Proveedor proveedor){
        Proveedor proveedorExistente = getProveedor(id_proveedor);
        if (proveedorExistente != null && proveedorExistente.getId_proveedor() != 0) {
            proveedor.setId_proveedor(id_proveedor);
            return proveedorRepository.save(proveedor);
        }
        return null;
    }


}
