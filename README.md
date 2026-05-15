# Frutos Velásquez - Sistema de Gestión de Microservicios

## Descripción del Proyecto
Este proyecto consiste en una arquitectura distribuida basada en microservicios para la gestión integral de una tienda de frutos secos ("Frutos Velásquez"). El sistema permite administrar el catálogo de productos, controlar el stock físico en tiempo real, gestionar compras a proveedores, procesar ventas con cálculo automático de precios y generar reportes de analítica financiera.

La solución está construida bajo el patrón **CSR (Controller-Service-Repository)**, asegurando una separación clara de responsabilidades y comunicación fluida entre servicios mediante **WebClient**.

## Integrantes del Equipo
* **Bruno** - Analista Programador
* **Oliver** - Analista Programador

## Funcionalidades Implementadas
1.  **API Gateway (Puerto 8081):** Punto de entrada único que centraliza y enruta todas las peticiones hacia los microservicios internos.
2.  **Microservicio de Catálogo:** Gestión completa de categorías y productos (precios, medidas y descripciones).
3.  **Microservicio de Inventario:** Control de existencias con registro de movimientos (Entradas, Salidas y Mermas) y validación de stock insuficiente.
4.  **Microservicio de Ventas:** Procesamiento de boletas con integración en tiempo real al Catálogo para obtención de precios y cálculo de subtotales.
5.  **Microservicio de Compras:** Registro de adquisiciones a proveedores y gestión de costos.
6.  **Microservicio de Analítica:** Generación de reportes diarios consolidados (Ingresos vs. Costos).

## Stack Tecnológico
* **Lenguaje:** Java 17+
* **Framework:** Spring Boot 3.x
* **Persistencia:** Spring Data JPA / Hibernate
* **Base de Datos:** MySQL
* **Comunicación Inter-servicios:** Spring WebFlux (WebClient)
* **Gestión de Versiones:** Git / GitHub

## Pasos para la Ejecución

### 1. Requisitos Previos
* Tener instalado JDK 17 o superior.
* Servidor MySQL activo.
* Postman o herramienta similar para pruebas de API.

### 2. Configuración de Base de Datos
Crear las bases de datos necesarias para cada microservicio en su respectivo entorno local:
* `db_catalogo`
* `db_inventario`
* `db_ventas`
* `db_compras`
* `db_analiticas`

### 3. Levantar los Microservicios

### 4. Pruebas de Endpoints
Todas las peticiones deben dirigirse al Gateway: `http://localhost:8081/api/v1/...`

Ejemplo de creación de producto:
`POST /catalogo/productos`

## Licencia
Proyecto desarrollado con fines académicos para la asignatura de Desarrollo FullStack 1 - Duoc UC.
