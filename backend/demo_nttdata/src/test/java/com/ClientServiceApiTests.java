package com;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.clientservice.ClientServiceAplication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ClientServiceAplication.class)
public class ClientServiceApiTests {

  @LocalServerPort
  private int port;

  @BeforeEach
  public void setUp() {
    RestAssured.port = port;
  }

  // Retrieve existing client by valid document type and number
  @Test
  public void test_return_client_with_correct_fields_for_existing_client() {
    String documentType = "C";
    String documentNumber = "23445322";

    given()
        .param("documentType", documentType)
        .param("documentNumber", documentNumber)
        .when()
        .get("/api/clients/query")
        .then()
        .statusCode(200)
        .body("firstName", equalTo("Jhenny"))
        .body("lastName", equalTo("Pérez"))
        .body("cityOfResidence", equalTo("Bogotá"));
  }

  // Handle null document type gracefully
  @Test
  public void test_handle_null_document_type() {
    String documentNumber = "123456789";

    given()
        .param("documentType", (String) null)
        .param("documentNumber", documentNumber)
        .when()
        .get("/api/clients/query")
        .then()
        .statusCode(400); // Suponemos que la API devuelve 400 en caso de tipo nulo
  }

  // Return Optional.empty() for non-existing client
  @Test
  public void test_return_empty_for_non_existing_client() {
    String documentType = "P";
    String documentNumber = "987654321";

    given()
        .param("documentType", documentType)
        .param("documentNumber", documentNumber)
        .when()
        .get("/api/clients/query")
        .then()
        .statusCode(404); // Suponemos que la API devuelve 404 en caso de cliente no encontrado
  }

  // Handle special characters in document type
  @Test
  public void test_handle_special_characters_in_document_type() {
    String documentType = "id card";
    String documentNumber = "A#1234";

    given()
        .param("documentType", documentType)
        .param("documentNumber", documentNumber)
        .when()
        .get("/api/clients/query")
        .then()
        .statusCode(400); // Asumimos que la API da error al tratarse de un imput malicioso
  }

  // Handle empty string as document type
  @Test
  public void test_handle_empty_document_type() {
    String documentType = "";
    String documentNumber = "123456789";

    given()
        .param("documentType", documentType)
        .param("documentNumber", documentNumber)
        .when()
        .get("/api/clients/query")
        .then()
        .statusCode(400); // Asumimos que la API devuelve 400 por tipo de documento vacío
  }
}
