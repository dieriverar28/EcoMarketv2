package com.ejemplo.ms_persona.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;

/**
 * Configuracion del WebClient para consumir ms-genero.
 *
 * WebClient es el cliente HTTP moderno de Spring (reemplaza a RestTemplate).
 * Aqui lo configuramos con:
 *   - baseUrl: apunta a ms-genero (localhost:8081)
 *   - Basic Auth: agrega el header Authorization en cada peticion
 */
@Configuration
public class WebClientConfig {

    @Value("${ms.genero.url}")
    private String generoUrl;

    @Value("${ms.genero.user}")
    private String generoUser;

    @Value("${ms.genero.password}")
    private String generoPassword;

    @Bean
    public WebClient generoWebClient() {
        // Construimos el header Basic Auth manualmente:
        // Base64(usuario:contraseña)
        String credenciales = generoUser + ":" + generoPassword;
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString(credenciales.getBytes());

        return WebClient.builder()
                .baseUrl(generoUrl)
                // defaultHeader: se envia en TODAS las peticiones de este WebClient
                .defaultHeader("Authorization", basicAuth)
                .build();
    }
}
