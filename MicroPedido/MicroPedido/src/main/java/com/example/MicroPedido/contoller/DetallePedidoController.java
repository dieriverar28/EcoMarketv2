package com.example.MicroPedido.contoller;

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

import com.example.EcoMarketSPA.model.DetallePedido;
import com.example.EcoMarketSPA.service.DetallePedidoService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v2/detalle_pedidos")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping 
    public List<DetallePedido> listarDetallePedidos(){
        return detallePedidoService.getDetallesPedido();
    }

    //agregar
    @PostMapping
    public DetallePedido agregarDetallePedido(@Valid @RequestBody DetallePedido detallePedido){
        return detallePedidoService.saveDetallePedido(detallePedido);
    }
    //buscar
    @GetMapping("{id_detalle_pedido}")
    public DetallePedido buscrDetallePedido(@PathVariable int id_detalle_pedido){
        return detallePedidoService.getDetallePedidoById(id_detalle_pedido);
    }
    //actualizar
    @PutMapping("{id_detalle_pedido}")
    public  int actualizarDetallePedido(@PathVariable int id_detalle_pedido, @Valid @RequestBody DetallePedido detallePedido){
        return detallePedidoService.updateDetallePedido(detallePedido);
    }
    //eliminar
    @DeleteMapping("{id_detalle_pedido}")
    public String eliminarDetallePedido(@PathVariable int id_detalle_pedido){
        if(detallePedidoService.deleteDetallePedido(id_detalle_pedido)==1){
            return "Detalle pedido eliminado correctamente";
        }
        return "Error al eliminar el detalle del pedido";
    }

}
