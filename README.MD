## Descripción
La API permite consultar información básica de clientes simulados (mock) mediante un servicio REST. Los datos almacenados incluyen:
- Tipo de documento (Cédula de ciudadanía, Pasaporte)
- Número de documento
- Nombres y apellidos
- Teléfono
- Dirección
- Ciudad de residencia


## Tecnologías Utilizadas
- **Backend:** Java 22, Spring Boot, Maven
- **Frontend:** Angular (localhost:4200)
- **Logging:** SLF4J y Logback para el manejo de logs
- **Base de Datos Simulada:** Datos mockeados de clientes

## Instalación

### Clonar el Repositorio
Clona ambos proyectos (backend y frontend) desde este mismo repositorio:

```bash
git clone https://github.com/danny-palma/test_nttdata.git
```

### Backend (Spring Boot)
1. **Instalar dependencias:**
   Navega a la carpeta del backend y ejecuta:
   ```bash
   mvn clean install
   ```

2. **Ejecutar la aplicación:**
   Ejecuta el backend con:
   ```bash
   mvn spring-boot:run
   ```
   El backend estará disponible en `http://localhost:8090`.

### Frontend (Angular)
1. **Instalar dependencias:**
   Navega a la carpeta del frontend y ejecuta:
   ```bash
   npm install
   ```

2. **Ejecutar la aplicación:**
   Ejecuta el frontend con:
   ```bash
   ng serve
   ```
   El frontend estará disponible en `http://localhost:4200`.

## Uso del Proyecto

### Solicitudes a la API
El servicio REST está disponible en:
```
GET http://localhost:8090/api/clients/query?documentType=C&documentNumber=23445322
```

Este endpoint permite realizar consultas de clientes mediante el tipo y número de documento. El frontend desarrollado permite interactuar visualmente con este servicio.

### Manejo de Logs
El proyecto está configurado para registrar todas las solicitudes y respuestas tanto en consola como en un archivo de log. Los logs se pueden consultar en el archivo `logs/application.log`.

## Habilidades Demostradas
Este proyecto fue desarrollado para demostrar mis habilidades en:
- Desarrollo de APIs RESTful con **Java** y **Spring Boot**
- Configuración de **CORS** para la interacción entre frontend y backend
- Manejo eficiente de **logs** utilizando SLF4J y Logback
- Buen uso de las herramientas en el frontend como lo son Angular y Bootstrap
- Implementación de buenas prácticas de **documentación** y estructuración del código
