
package com.clientservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
  private String documentType; // Tipo de documento (c, p)
  private String documentNumber; // Número de documento
  private String firstName;
  private String middleName;
  private String lastName;
  private String secondLastName;
  private String phone;
  private String address;
  private String cityOfResidence;
}
