# TP1 · Spring Boot, API REST y arquitectura en capas

API REST desarrollada con Spring Boot, aplicando una arquitectura en capas y separando controllers, services, repositories, DTOs y clientes externos.

El proyecto consume productos desde DummyJSON y administra favoritos mediante un repository en memoria.

## Cómo levantar el proyecto

Requiere Java 25. Usar siempre el wrapper, nunca un `mvn` instalado aparte:

```bash
# Windows
.\mvnw.cmd spring-boot:run

# macOS/Linux
./mvnw spring-boot:run
```

Cuando el log muestre `Started DemoApplication`, la aplicación queda escuchando en:

`http://localhost:8080`

Para compilar y ejecutar los tests:

```bash
./mvnw test
```

En Windows:

```bash
.\mvnw.cmd test
```

## Endpoints disponibles

### Products

Los productos son obtenidos desde DummyJSON y transformados al DTO propio de la aplicación.

| Método | Path                 | Qué hace                    |
| ------ | -------------------- | --------------------------- |
| GET    | `/api/products`      | Obtiene productos paginados |
| GET    | `/api/products/{id}` | Obtiene un producto por ID  |

La paginación utiliza los parámetros:

```text
/api/products?limit=10&skip=0
```

* `limit`: cantidad de productos a devolver. Mínimo `1`.
* `skip`: cantidad de productos a omitir. Mínimo `0`.

### Favorites

Los favoritos se almacenan en memoria mientras la aplicación está ejecutándose.

| Método | Path                  | Qué hace                    |
| ------ | --------------------- | --------------------------- |
| GET    | `/api/favorites`      | Obtiene todos los favoritos |
| GET    | `/api/favorites/{id}` | Obtiene un favorito por ID  |
| POST   | `/api/favorites`      | Crea un favorito            |
| PUT    | `/api/favorites/{id}` | Actualiza un favorito       |
| DELETE | `/api/favorites/{id}` | Elimina un favorito         |

## Swagger / OpenAPI

La documentación de la API está disponible mediante Swagger UI:

`http://localhost:8080/swagger-ui/index.html`

Desde allí se pueden consultar y ejecutar los endpoints de `Products` y `Favorites`.


## Dependencias principales

* **`spring-boot-starter-webmvc`** — Spring MVC y Tomcat embebido.
* **`spring-boot-starter-validation`** — Bean Validation (`@NotNull`, `@NotBlank`, `@Min`, etc.).
* **`springdoc-openapi-starter-webmvc-ui`** — Swagger UI / OpenAPI.
