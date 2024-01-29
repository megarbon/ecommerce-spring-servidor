# Ecommerce en Java Spring Boot

Este repositorio contiene el trabajo final de desarrollo de aplicaciones web en entorno servidor, enfocado en la creación de un sistema de comercio electrónico utilizando Java Spring Boot. Este proyecto busca demostrar las habilidades y conocimientos adquiridos en el desarrollo de aplicaciones en el lado del servidor.

## Características Principales

- **Tecnologías Utilizadas**: El proyecto está desarrollado utilizando Java con el framework Spring Boot, El front está escrito en HTML, CSS, JS y TailwindCss.

- **Arquitectura MVC**: Se sigue una arquitectura Modelo-Vista-Controlador (MVC) para garantizar la separación de preocupaciones y la modularidad del sistema.

- **Gestión de Usuarios**: Implementación de un sistema de autenticación y autorización para la gestión de usuarios, permitiendo el acceso seguro a las funcionalidades del ecommerce.

- **Catálogo de Productos**: Desarrollo de un catálogo de productos con operaciones de lectura, creación, actualización y eliminación (CRUD), brindando a los usuarios la capacidad de explorar y adquirir productos.

- **Carrito de Compras**: Integración de un carrito de compras que permite a los usuarios agregar y gestionar los productos que desean comprar antes de proceder al pago.

- **Proceso de Pago**: Implementación de un sistema de pago seguro para completar las transacciones, utilizando las mejores prácticas de seguridad en el manejo de información financiera.

## Configuración del Proyecto

1. **Clonar el Repositorio**: `git clone https://github.com/megarbon/ecommerce-spring-servidor.git`

2. **Configuración de la Base de Datos**: Configurar la conexión a la base de datos en el archivo `application.properties`.

3. **Compilación y Ejecución**: Utilizar Maven para compilar el proyecto y ejecutar la aplicación.

```bash
mvn clean install
mvn spring-boot:run
```

4. **Acceso a la Aplicación**: Una vez que la aplicación esté en ejecución, acceder a `http://localhost:8080` para explorar el ecommerce.

5. **Rest Client**: Necesitarás hacer uso de un cliente Rest como puede ser Postman para poder acceder a los diferentes endpoints de la API. Desde el navegador también se puede pero es más incómodo.

## Contribuciones

Las contribuciones son bienvenidas. Si encuentras errores, mejoras o nuevas características que podrían agregarse, no dudes en abrir un problema o enviar una solicitud de extracción.

¡Gracias por contribuir al desarrollo de este proyecto!
