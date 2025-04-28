/**
 * -------------------------------------------------------------------
 *?Archivo: ClientService.java
 *?Autor: Daniel Alejandro Palma Garcia
 *?Correo: dannypalmadev@gmail.com
 *?Fecha: Octubre 2024
 *?Empresa: NTT Data
 *
 *?Descripción:
 * Esta interfaz define los métodos que deben ser implementados por el
 * servicio de cliente. El método principal es getClientByDocument, 
 * que permite la búsqueda de un cliente basándose en el tipo y número
 * de documento.
 * 
 * La implementación de esta interfaz se encarga de encapsular la 
 * lógica de negocio relacionada con la búsqueda y manipulación de los
 * datos de los clientes en la aplicación.
 * -------------------------------------------------------------------
 */
package com.dannypalmadev.clientservice.service;

import com.dannypalmadev.clientservice.dto.ClientDto;

import java.util.Optional;

public interface ClientService {
  Optional<ClientDto> getClientByDocument(String documentType, String documentNumber);
}