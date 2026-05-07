package com.example.MicroCliente.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketv2.model.Cliente;
import com.example.EcoMarketv2.repository.ClienteRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public interface ClienteService {
    List<ClienteDTO.Response>listarTodos();
    ClienteDTO.Response busparPorId(int id_cliente);
    ClienteDTO.Response buscarPorNombre(String nombre);
    ClienteDTO.Response buscarPorGenero(GeneroDTO generoId);
    ClienteDTO.Response crearCliente(ClienteDTO.Request request);
    ClienteDTO actualizarCliente(int id_cliente, ClienteDTO.Request request);
    void eliminarCliente(int id_cliente);
}
