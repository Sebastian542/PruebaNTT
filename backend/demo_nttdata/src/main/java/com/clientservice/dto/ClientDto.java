

package com.clientservice.dto;

import lombok.Data;

@Data
public class ClientDto {
  private String firstName;
  private String lastName;
  private String cityOfResidence;
  private String phone;
  private String address;
}