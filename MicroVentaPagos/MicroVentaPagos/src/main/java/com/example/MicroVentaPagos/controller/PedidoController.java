package com.example.MicroVentaPagos.controller;

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

import com.example.EcoMarketSPA.model.Pedido;
import com.example.EcoMarketSPA.service.PedidoService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v2/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarPedidos(){
        return pedidoService.getPedidos();
    }
    //agregar
    @PostMapping
    public Pedido agregarPedido(@Valid @RequestBody Pedido pedido){
        return pedidoService.savePedido(pedido);
     }
    //buscar
    @GetMapping("/{id_pedido}")
    public Pedido buscarPedido(@PathVariable int id_pedido){
        return pedidoService.getPedido(id_pedido);
    }
    //actualizar
    @PutMapping("/{id_pedido}")
    public int actualizarPedido(@PathVariable int id_pedido, @Valid @RequestBody Pedido pedido){
        return pedidoService.updatePedido(pedido);
    }
    //eliminar
    @DeleteMapping("/{id_pedido}")
    public String eliminarPedido(@PathVariable int id_pedido){
        if (pedidoService.deletePedido(id_pedido)== 1) {
            return "Pedido eliminado correctamente";
        }
        return "Error al eliminar el pedido";
    }

}
