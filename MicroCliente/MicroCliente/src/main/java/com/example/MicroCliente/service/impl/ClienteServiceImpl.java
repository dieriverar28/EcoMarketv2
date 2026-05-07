package com.ejemplo.MicroCliente.service.impl;

import com.ejemplo.MicroCliente.dto.GeneroDTO;
import com.ejemplo.MicroCliente.dto.ClienteDTO;
import com.ejemplo.MicroCliente.model.Cliente;
import com.ejemplo.MicroCliente.repository.ClienteRepository;
import com.ejemplo.MicroCliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    /**
     * Spring inyecta el WebClient configurado en WebClientConfig.
     * Ya viene con la baseUrl y el header Basic Auth listos.
     */
    private final WebClient generoWebClient;

    @Override
    @Transactional(readOnly = true)
    public List<ClienteDTO.Response> listarTodos() {
        log.info("[MicroCliente] Listando todas las personas");
        return clienteRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteDTO.Response buscarPorId(Long id) {
        log.info("[MicroCliente] Buscando cliente id: {}", id);
        Cliente cliente = ClienteRepository.findById(id_cliente)
                .orElseThrow(() -> {
                    log.error("[MicroCliente] Persona no encontrada id: {}", id);
                    return new RuntimeException("Persona no encontrada con id: " + id);
                });
        return mapToResponse(cliente);
    }

    

    @Override
    @Transactional(readOnly = true)
    public List<ClienteDTO.Response> buscarPorGenero(Long generoId) {
        log.info("[MicroCliente] Buscando personas con generoId: {}", generoId);
        return personaRepository.findByGeneroId(generoId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ClienteDTO.Response crear(ClienteDTO.Request request) {
        log.info("[MicroCliente] Creando persona RUT: {}", request.getId());

        if (clienteRepository.existsById(request.getId_cliente())) {
            throw new RuntimeException("Ya existe una persona con el id: " + request.getId_cliente());
        }

        // Verificamos que el genero exista en ms-genero ANTES de guardar
        verificarGeneroExiste(request.getGeneroId());

        Cliente cliente = new Cliente();
        cliente.setId(request.getId());
        cliente.setNombre(request.getNombre());
        cliente.setEmail(request.getEmail());
        cliente.setGeneroId(request.getGeneroId());

        Cliente guardada = clienteRepository.save(cliente);
        log.info("[MicroCliente] Persona creada id: {}", guardada.getId());
        return mapToResponse(guardada);
    }

    @Override
    @Transactional
    public ClienteDTO.Response actualizarCliente(Long id, ClienteDTO.Request request) {
        log.info("[MicroCliente] Actualizando persona id: {}", id);

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrada con id: " + id));

        verificarGeneroExiste(request.getGeneroId());

        persona.setRut(request.getRut());
        persona.setNombre(request.getNombre());
        persona.setEdad(request.getEdad());
        persona.setGeneroId(request.getGeneroId());
        cliente.setId(request.getId());
        cliente.setNombre(request.getNombre());
        cliente.setEmail(request.getEmail());
        cliente.setTelefono(request.getTelefono());
        cliente.setComuna(request.getComuna());
        cliente.setDireccion_Envio(request.getDireccion_Envio());

        return mapToResponse(personaRepository.save(persona));
    }

    @Override
    @Transactional
    public void eliminarCliente(int id) {
        log.info("[MicroCliente] Eliminando cliente id: {}", id);
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Persona no encontrada con id: " + id);
        }
        clienteRepository.deleteById(id);
    }

    /**
     * Llama a ms-genero via WebClient para verificar que el genero existe.
     *
     * Flujo de la llamada HTTP:
     *   generoWebClient                           → cliente ya configurado con baseUrl + auth
     *   .get()                                    → metodo HTTP GET
     *   .uri("/api/generos/{id}", generoId)       → construye la URL: baseUrl + /api/generos/1
     *   .retrieve()                               → ejecuta la peticion
     *   .bodyToMono(GeneroDTO.class)              → deserializa el JSON a GeneroDTO
     *   .block()                                  → bloquea hasta obtener la respuesta (sincrono)
     */
    private void verificarGeneroExiste(Long generoId) {
        try {
            generoWebClient
                    .get()
                    .uri("/api/generos/{id}", generoId)
                    .retrieve()
                    .bodyToMono(GeneroDTO.class)
                    .block(); // Convertimos la llamada reactiva a sincrona

            log.debug("[MicroCliente] Genero id {} verificado en MicroGenero", generoId);

        } catch (WebClientResponseException.NotFound e) {
            throw new RuntimeException("El genero con id " + generoId + " no existe en ms-genero");
        } catch (Exception e) {
            log.error("[MicroCliente] Error al comunicarse con MicroGenero: {}", e.getMessage());
            throw new RuntimeException("Error de comunicacion con MicroGenero: " + e.getMessage());
        }
    }

    /**
     * Mapeo Entity -> DTO.
     * Llama a ms-genero via WebClient para enriquecer la respuesta con los datos del genero.
     */
    private ClienteDTO.Response mapToResponse(Cliente cliente) {
        GeneroDTO genero = null;

        try {
            genero = generoWebClient
                    .get()
                    .uri("/api/generos/{id}", cliente.getGeneroId())
                    .retrieve()
                    .bodyToMono(GeneroDTO.class)
                    .block();

            log.debug("[MicroCliente] Genero obtenido desde MicroGenero: {}", genero.getDescripcion());

        } catch (Exception e) {
            // Si ms-genero no responde, devolvemos la persona igual con genero parcial
            log.warn("[MicroCliente] No se pudo obtener genero id: {} - {}", cliente.getGeneroId(), e.getMessage());
            genero = new GeneroDTO(persona.getGeneroId(), "No disponible");
        }

        return new ClienteDTO.Response(
                
                cliente.getId_cliente(),
                cliente.getNombre(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getComuna(),
                cliente.getDireccion_Envio(),
                genero
        );
    }
}
