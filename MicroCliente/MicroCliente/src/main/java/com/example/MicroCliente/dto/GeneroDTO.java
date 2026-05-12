package com.example.MicroCliente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO que representa la respuesta de ms-genero cuando Feign lo consulta.
 * Debe coincidir con el GeneroDTO.Response de ms-genero.
 * No necesita anotaciones de validación porque es solo para recibir datos.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneroDTO {
    private Long id;
    private String descripcion;
}
