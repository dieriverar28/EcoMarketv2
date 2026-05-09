package com.example.MicroPedido.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.example.EcoMarketSPA.model.DetallePedido;

@Repository
public class DetallePedidoRepository {
    //Lista para guardar detalle pedidos
    private List<DetallePedido>detalles=new ArrayList<>();

    //OBTNENER TODOS
    public List<DetallePedido> obtenerDetallePedido(){
        return detalles;
    }

    //BUSCAR X id_detalle
    public DetallePedido buscarDetallePedido(int id_detalle){
        for (DetallePedido dp : detalles) {
            if (dp.getId_detalle() == id_detalle) {
                return dp;
            }
        }
        return null;
    }

    // ELIMINAR POR ID
    public int eliminarDetallePedido(int id_detalle) {
        for (int i = 0; i < detalles.size(); i++) {
            if (detalles.get(i).getId_detalle() == id_detalle) {
                detalles.remove(i);
                return 1;
            }
        }
        return 0;
    }

    // GUARDAR Cupon
    public DetallePedido guardarDetallePedido(DetallePedido detalle) {
        detalles.add(detalle);
        return detalle;
    }

    // MODIFICAR COMUNA
    public int modificarDetallePedido(DetallePedido detalle) {
    try {
        for (int i = 0; i < detalles.size(); i++) {
            if (detalles.get(i).getId_detalle() == detalle.getId_detalle()) {
                detalles.get(i).setCantidad(detalle.getCantidad());
                detalles.get(i).setPrecio_unitario(detalle.getPrecio_unitario());
                return 1; // modificado
            }
        }
        return 0; // no encontrado
    } catch (Exception e) {
        return -1; // error
    }
    }

}
