package com.example.MicroDescuento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MicroDescuento.model.CuponDescuento;

@Repository
public interface CuponDescuentoRepository extends JpaRepository<CuponDescuento, Integer> {

    @Query("SELECT c FROM CuponDescuento c")
    List<CuponDescuento> obtenerCuponDescuentos();

    @Query("SELECT c FROM CuponDescuento c WHERE c.id_cupon_descuento = :id_cupon_descuento")
    CuponDescuento buscarCuponDescuento(int id_cupon_descuento);

}