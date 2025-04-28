/**
 * -------------------------------------------------------------------
 *?Archivo: CorsConfig.java
 *?Autor: Daniel Alejandro Palma Garcia
 *?Correo: dannypalmadev@gmail.com
 *?Fecha: Octubre 2024
 *?Empresa: NTT Data
 *
 *?Descripción:
 * Este archivo contiene la configuración global de CORS para la
 * aplicación backend. Permite solicitudes desde el 
 * frontend que corre en http://localhost:4200.
 *
 * Esta configuración permite compartir recursos entre dominios,
 * habilitando el intercambio de datos entre el frontend (Angular)
 * y el backend (Spring Boot).
 *
 * - Permite solicitudes de origen http://localhost:4200
 * - Métodos permitidos: GET, POST, PUT, DELETE, OPTIONS
 * - Se permiten todos los headers
 * - Se permite el uso de credenciales
 * -------------------------------------------------------------------
 */

package com.clientservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        // Permite solicitudes desde localhost:4200
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:4200")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true);
      }
    };
  }
}
