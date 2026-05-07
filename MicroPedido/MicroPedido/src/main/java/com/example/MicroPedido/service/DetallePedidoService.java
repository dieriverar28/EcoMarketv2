package com.example.MicroPedido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketSPA.model.DetallePedido;
import com.example.EcoMarketSPA.repository.DetallePedidoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DetallePedidoService {
    @Autowired
//SE LLAMA AL REPOSITORIO DE DETALLE PEDIDO PARA REALIZAR LAS OPERACIONES DE LA BASE DE DATOS
    private DetallePedidoRepository detallePedidoRepository;  
     
//OBTENER DETALLE PEDIDO POR ID
    public DetallePedido getDetallePedidoById(int id_detalle_pedido) {
        return detallePedidoRepository.buscarDetallePedido(id_detalle_pedido);
    }
//CREAR DETALLE PEDIDO
    public DetallePedido saveDetallePedido(DetallePedido detallePedido) {
        return detallePedidoRepository.guardarDetallePedido(detallePedido);
    }
//ACTUALIZAR DETALLE PEDIDO
    public int updateDetallePedido(DetallePedido detallePedido) {
        return detallePedidoRepository.modificarDetallePedido(detallePedido);
    }
//ELIMINAR DETALLE PEDIDO
    public int deleteDetallePedido(int id_detalle_pedido) {
        return detallePedidoRepository.eliminarDetallePedido(id_detalle_pedido);
    }  
//OBETENER TODOS LOS DETALLES PEDIDO
    public List<DetallePedido> getDetallesPedido() {
        return detallePedidoRepository.obtenerDetallePedido();
    }

}
