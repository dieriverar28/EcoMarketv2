package com.ejemplo.ms_persona.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PersonaDTO {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {

        @NotBlank(message = "El RUT es obligatorio")
        @Size(min = 10, max = 12, message = "El RUT debe tener entre 10 y 12 caracteres")
        private String rut;

        @NotBlank(message = "El nombre es obligatorio")
        @Pattern(regexp = "^[\\w\\sáéíóúÁÉÍÓÚñÑ]{2,}\\s+[\\w\\sáéíóúÁÉÍÓÚñÑ]{2,}.*$",
                 message = "El nombre debe contener al menos 2 palabras")
        private String nombre;

        @Min(value = 0, message = "La edad no puede ser negativa")
        @Max(value = 120, message = "La edad no puede superar 120 años")
        private int edad;

        @NotNull(message = "El ID del género es obligatorio")
        private Long generoId;
    }

    /**
     * La respuesta incluye el GeneroDTO completo obtenido desde ms-genero via Feign.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String rut;
        private String nombre;
        private int edad;
        private GeneroDTO genero; // Objeto obtenido consultando ms-genero
    }
}
