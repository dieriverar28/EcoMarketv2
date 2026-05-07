package com.example.MicroDescuento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroDescuento.model.CuponDescuento;
import com.example.MicroDescuento.repository.CuponDescuentoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class CuponDescuentoService {

    @Autowired
    //SE LLAMA AL REPOSITORIO DE CUPON DESCUENTO PARA REALIZAR LAS OPERACIONES DE LA BASE DE DATOS
    private CuponDescuentoRepository cuponDescuentoRepository;

    //OBTENER TODOS LOS CUPONES DE DESCUENTO
    public List<CuponDescuento> getAllCupones() {
        return cuponDescuentoRepository.findAll();
    }

    //OBTENER CUPON DESCUENTO POR ID
    public CuponDescuento getCuponDescuentoById(int id_cupon_descuento) {

        CuponDescuento cuponDescuentos =
                cuponDescuentoRepository.buscarCuponDescuento(id_cupon_descuento);

        if (cuponDescuentos != null) {
            return cuponDescuentos;
        } else {
            return new CuponDescuento();
        }
    }

    //CREAR CUPON DESCUENTO
    public CuponDescuento saveCuponDescuento(CuponDescuento cuponDescuento) {
        return cuponDescuentoRepository.save(cuponDescuento);
    }

    //ACTUALIZAR CUPON DESCUENTO
    public int updateCuponDescuento(CuponDescuento cuponDescuento) {
        cuponDescuentoRepository.save(cuponDescuento);
        return 1;
    }

    //ELIMINAR CUPON DESCUENTO
    public int deleteCuponDescuento(int id_cupon_descuento) {

        cuponDescuentoRepository.delete(
                getCuponDescuentoById(id_cupon_descuento)
        );

        return 1;
    }
}