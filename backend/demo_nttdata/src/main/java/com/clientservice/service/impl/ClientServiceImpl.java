/**
 * -------------------------------------------------------------------
 *?Archivo: ClientServiceImpl.java
 *?Autor: Daniel Alejandro Palma Garcia
 *?Correo: dannypalmadev@gmail.com
 *?Fecha: Octubre 2024
 *?Empresa: NTT Data
 *
 *?Descripción:
 * Esta clase implementa la lógica del servicio de cliente. Utiliza un
 * Map<String, Client> para almacenar múltiples clientes simulados y 
 * permite la búsqueda de clientes basándose en el tipo y número de 
 * documento.
 * 
 * Proporciona el método getClientByDocument, que devuelve un DTO con 
 * la información del cliente si coincide con los datos ingresados, o
 * un Optional.empty() si no se encuentra.
 * 
 * La clase ClientServiceImpl demuestra el uso de estructuras de datos
 * eficientes como Map para almacenar y buscar información rápidamente.
 * -------------------------------------------------------------------
 */

package com.dannypalmadev.clientservice.service.impl;

import com.dannypalmadev.clientservice.dto.ClientDto;
import com.dannypalmadev.clientservice.model.Client;
import com.dannypalmadev.clientservice.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

  // Usamos un Map para almacenar múltiples clientes
  private static final Map<String, Client> CLIENTS_MOCK = new HashMap<>();

  // Bloque estático para agregar clientes a CLIENTS_MOCK al inicio
  static {
    CLIENTS_MOCK.put("c-23445322", new Client(
        "c", "23445322", "Jhenny", "José", "Pérez", "Rodríguez",
        "123456789", "Cra. 8 #7 - 26", "Bogotá"));
  }

  // Método para construir la clave basada en tipo y número de documento
  private String buildKey(String documentType, String documentNumber) {
    return documentType + "-" + documentNumber;
  }

  @Override
  public Optional<ClientDto> getClientByDocument(String documentType, String documentNumber) {
    // Buscamos el cliente en el Map utilizando la clave generada
    Client client = CLIENTS_MOCK.get(buildKey(documentType, documentNumber));

    if (client != null) {
      // Mapear el modelo Client a ClientDto
      ClientDto clientDto = new ClientDto();
      clientDto.setFirstName(client.getFirstName());
      clientDto.setLastName(client.getLastName());
      clientDto.setCityOfResidence(client.getCityOfResidence());
      clientDto.setPhone(client.getPhone());
      clientDto.setAddress(client.getAddress());
      return Optional.of(clientDto);
    } else {
      return Optional.empty();
    }
  }
}
