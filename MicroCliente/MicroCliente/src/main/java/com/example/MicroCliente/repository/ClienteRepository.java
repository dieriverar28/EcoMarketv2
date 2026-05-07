package com.example.MicroCliente.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.EcoMarketSPA.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    Optional<Cliente> findbyId(int id_cliente);

    boolean existexistsById(int id_cliente);

    List<Cliente> findByGeneroId(Genero generoid);
    
}
