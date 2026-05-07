package com.example.MicroCliente.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketSPA.model.Cliente;
import com.example.EcoMarketSPA.repository.ClienteRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ClienteService {
    @Autowired
    //SE LLAMA AL REPOSITORIO PARA PODER USAR SUS FUNCIONES
        private ClienteRepository clienteRepository; 
    
    //OBTENER clientes
        public List<Cliente> getClientes() {
            return clienteRepository.obtenerClientes();
        }
    //OBTENER CLIENTE POR ID
        public Cliente getClienteById(int id_cliente) {
            Cliente cliente = clienteRepository.buscarCliente(id_cliente);
            if (cliente!=null) {
            return cliente;
            }else
            return new Cliente();
        }
    //CREAR cliente
        public Cliente saveClientes(Cliente cliente) {
            return clienteRepository.save(cliente);
        }
    //ACTUALIZAR cliente
        public int updateCliente(Cliente cliente) {
            clienteRepository.save(cliente);
            return 1;
        }
    //ELIMINAR cliente
        public int deleteCliente(int id_cliente) {
            clienteRepository.delete(getClienteById(id_cliente));
            return 1;
        }
}
