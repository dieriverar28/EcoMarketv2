package com.ejemplo.ms_persona.client;

import com.ejemplo.ms_persona.dto.GeneroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * FeignClient: interfaz que actúa como cliente HTTP hacia ms-genero.
 *
 * Spring genera automáticamente la implementación en tiempo de ejecución.
 * Solo definimos los métodos que necesitamos consumir del otro microservicio.
 *
 * name       → nombre lógico del cliente (identificador interno)
 * url        → leída desde application.properties (ms.genero.url)
 * configuration → clase que inyecta las credenciales Basic Auth en cada petición
 */
@FeignClient(
    name = "ms-genero",
    url = "${ms.genero.url}",
    configuration = FeignClientConfig.class
)
public interface GeneroClient {

    /**
     * Llama a GET http://localhost:8081/api/generos/{id}
     * Si el género no existe, Feign lanza FeignException que manejamos en el servicio.
     */
    @GetMapping("/api/generos/{id}")
    GeneroDTO buscarPorId(@PathVariable("id") Long id);
}
