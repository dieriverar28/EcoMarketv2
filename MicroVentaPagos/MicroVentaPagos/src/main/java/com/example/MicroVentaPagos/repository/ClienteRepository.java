package com.example.MicroVentaPagos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.EcoMarketSPA.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
 @Query("SELECT c FROM Cliente c")
    List<Cliente> obtenerClientes();

    @Query("SELECT c FROM Cliente c WHERE c.id_cliente = :id_cliente")
    Cliente buscarCliente(int id_cliente);
}
