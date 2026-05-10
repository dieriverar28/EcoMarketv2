package com.example.MicroPostventa.modelo;

import java.util.List;

import org.aspectj.apache.bcel.generic.InstructionConstants.Clinit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcoMarketSPA.model.Cliente;
import com.example.EcoMarketSPA.service.ClienteService;

import jakarta.validation.Valid;



@SuppressWarnings("unused")
@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteService.getClientes();
    }
    //agregar
    @PostMapping
    public Cliente agregarCliente(@Valid @RequestBody Cliente cliente){
        return clienteService.saveClientes(cliente);

    }
    //buscar
    @GetMapping("{id_cliente}")
    public Cliente buscraCliente(@PathVariable int id_cliente){
        return clienteService.getClienteById(id_cliente);
    }
    //actualizar
    @PutMapping("{id_cliente}")
    public int actualizarClinte(@PathVariable int id_cliente, @Valid @RequestBody Cliente cliente){
        return clienteService.updateCliente(cliente);
    }
    //eliminar
    @DeleteMapping("{id_cliente}")
    public String elimiarCliente(@PathVariable int id_clinte){
        if (clienteService.deleteCliente(id_clinte)==1) {
            return "Cliente eliminado correctamente";
        }
        return "Error al eliminar el cliente";
    }

}
