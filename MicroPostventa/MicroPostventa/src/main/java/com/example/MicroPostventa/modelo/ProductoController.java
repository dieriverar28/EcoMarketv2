package com.example.MicroPostventa.modelo;

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

import com.example.EcoMarketSPA.model.Producto;
import com.example.EcoMarketSPA.service.ProductoService;

import jakarta.validation.Valid;
@SuppressWarnings("unused")
@RestController
@RequestMapping ("api/v1/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listarProductos(){
        return productoService.getProductos();
    }
    //agregar
    @PostMapping
    public Producto agregarProducto(@Valid @RequestBody Producto producto){
        return productoService.saveProducto(producto);
    }
    //buscar
    @GetMapping("/{id_producto}")
    public Producto buscarProducto(@PathVariable int id_producto){
        return productoService.getProducto(id_producto);
    }
    //actualizar
    @PutMapping("/{id_producto}")
    public Producto actualizarProducto(@PathVariable int id_producto, @Valid @RequestBody Producto producto){
        return productoService.updateProducto(id_producto, producto);
    }
    //eliminar
    @DeleteMapping("/{id_producto}")
    public String eliminarProducto(@PathVariable int id_producto){
        if (productoService.deleteProducto(id_producto)== 1) {
            return "Producto eliminado correctamente";
        }
        return "Error al eliminar el producto";
    }

}
