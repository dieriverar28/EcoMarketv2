package com.example.MicroProducto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MicroProducto.modelo.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query("SELECT p FROM Producto p")
    List<Producto> obtenerProductos();

    @Query("SELECT p FROM Producto p WHERE p.id_producto = :id_producto")
    Producto buscarProducto(int id_producto);
}
