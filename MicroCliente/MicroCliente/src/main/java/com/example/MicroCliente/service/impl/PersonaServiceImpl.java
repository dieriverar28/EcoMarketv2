package com.ejemplo.ms_persona.service.impl;

import com.ejemplo.ms_persona.dto.GeneroDTO;
import com.ejemplo.ms_persona.dto.PersonaDTO;
import com.ejemplo.ms_persona.entity.Persona;
import com.ejemplo.ms_persona.repository.PersonaRepository;
import com.ejemplo.ms_persona.service.PersonaService;
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
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    /**
     * Spring inyecta el WebClient configurado en WebClientConfig.
     * Ya viene con la baseUrl y el header Basic Auth listos.
     */
    private final WebClient generoWebClient;

    @Override
    @Transactional(readOnly = true)
    public List<PersonaDTO.Response> listarTodos() {
        log.info("[ms-persona] Listando todas las personas");
        return personaRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PersonaDTO.Response buscarPorId(Long id) {
        log.info("[ms-persona] Buscando persona id: {}", id);
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("[ms-persona] Persona no encontrada id: {}", id);
                    return new RuntimeException("Persona no encontrada con id: " + id);
                });
        return mapToResponse(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonaDTO.Response buscarPorRut(String rut) {
        log.info("[ms-persona] Buscando persona RUT: {}", rut);
        Persona persona = personaRepository.findByRut(rut)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con RUT: " + rut));
        return mapToResponse(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonaDTO.Response> buscarPorGenero(Long generoId) {
        log.info("[ms-persona] Buscando personas con generoId: {}", generoId);
        return personaRepository.findByGeneroId(generoId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PersonaDTO.Response crear(PersonaDTO.Request request) {
        log.info("[ms-persona] Creando persona RUT: {}", request.getRut());

        if (personaRepository.existsByRut(request.getRut())) {
            throw new RuntimeException("Ya existe una persona con el RUT: " + request.getRut());
        }

        // Verificamos que el genero exista en ms-genero ANTES de guardar
        verificarGeneroExiste(request.getGeneroId());

        Persona persona = new Persona();
        persona.setRut(request.getRut());
        persona.setNombre(request.getNombre());
        persona.setEdad(request.getEdad());
        persona.setGeneroId(request.getGeneroId());

        Persona guardada = personaRepository.save(persona);
        log.info("[ms-persona] Persona creada id: {}", guardada.getId());
        return mapToResponse(guardada);
    }

    @Override
    @Transactional
    public PersonaDTO.Response actualizar(Long id, PersonaDTO.Request request) {
        log.info("[ms-persona] Actualizando persona id: {}", id);

        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con id: " + id));

        verificarGeneroExiste(request.getGeneroId());

        persona.setRut(request.getRut());
        persona.setNombre(request.getNombre());
        persona.setEdad(request.getEdad());
        persona.setGeneroId(request.getGeneroId());

        return mapToResponse(personaRepository.save(persona));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        log.info("[ms-persona] Eliminando persona id: {}", id);
        if (!personaRepository.existsById(id)) {
            throw new RuntimeException("Persona no encontrada con id: " + id);
        }
        personaRepository.deleteById(id);
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

            log.debug("[ms-persona] Genero id {} verificado en ms-genero", generoId);

        } catch (WebClientResponseException.NotFound e) {
            throw new RuntimeException("El genero con id " + generoId + " no existe en ms-genero");
        } catch (Exception e) {
            log.error("[ms-persona] Error al comunicarse con ms-genero: {}", e.getMessage());
            throw new RuntimeException("Error de comunicacion con ms-genero: " + e.getMessage());
        }
    }

    /**
     * Mapeo Entity -> DTO.
     * Llama a ms-genero via WebClient para enriquecer la respuesta con los datos del genero.
     */
    private PersonaDTO.Response mapToResponse(Persona persona) {
        GeneroDTO genero = null;

        try {
            genero = generoWebClient
                    .get()
                    .uri("/api/generos/{id}", persona.getGeneroId())
                    .retrieve()
                    .bodyToMono(GeneroDTO.class)
                    .block();

            log.debug("[ms-persona] Genero obtenido desde ms-genero: {}", genero.getDescripcion());

        } catch (Exception e) {
            // Si ms-genero no responde, devolvemos la persona igual con genero parcial
            log.warn("[ms-persona] No se pudo obtener genero id: {} - {}", persona.getGeneroId(), e.getMessage());
            genero = new GeneroDTO(persona.getGeneroId(), "No disponible");
        }

        return new PersonaDTO.Response(
                persona.getId(),
                persona.getRut(),
                persona.getNombre(),
                persona.getEdad(),
                genero
        );
    }
}
