# 🖥️ Foro Hub

## 📄 Descripción
**Foro Hub** es una REST API diseñada para crear y gestionar tópicos y respuestas en un foro de manera sencilla y eficiente.

## ⚙️ Tecnologías usadas
- **Java** (17 en adelante)
- **Maven** (versión 4)
- **Spring Boot**
- **Proyecto en formato JAR**
- **Lombok**
- **Spring Web**
- **Spring Boot DevTools**
- **Spring Data JPA**
- **Flyway Migration**
- **MySQL Driver**
- **Validation**
- **Spring Security**

## 🚀 Instalación y ejecución

Sigue estos pasos para levantar el proyecto localmente:

1. **Clonar el repositorio**
   ```bash
   git clone <URL_DE_TU_REPOSITORIO>
   cd foro-hub
   ```

2. **Configurar la base de datos**
   - Crea una base de datos MySQL (por ejemplo, `foro_hub_db`)
   - Configura las credenciales en `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub_db
     spring.datasource.username=TU_USUARIO
     spring.datasource.password=TU_CONTRASEÑA
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

3. **Construir el proyecto**
   ```bash
   mvn clean package
   ```

4. **Ejecutar el JAR**
   ```bash
   java -jar target/foro-hub-0.0.1-SNAPSHOT.jar
   ```

5. **Probar la API**
   - Accede a `http://localhost:8080`
   - Usa herramientas como **Postman** o **Insomnia** para interactuar con los endpoints.

## 🛠️ Uso / Ejemplos
- Crear un tópico
- Listar todos los tópicos
- Responder a un tópico
- Autenticación con Spring Security

*(Los endpoints detallados se encuentran en la documentación interna o en el Swagger, si está configurado.)*

## 👨‍💻 Autor
**Carlos Alberto Ramirez Monarrez**

## 📄 Licencia
Este proyecto está bajo licencia MIT. ¡Siéntete libre de usarlo y modificarlo!  

---

✨ **¡Gracias por usar Foro Hub!**  
Cualquier sugerencia o mejora es bienvenida.

