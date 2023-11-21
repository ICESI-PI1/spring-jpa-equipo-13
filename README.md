# Informe Taller de Integración de JPA en API REST con ReactJS y Autenticación JWT

**Integrantes:**

- Juan Jose Diaz Parra - A00381098
- Mateo Silva Lasso - A00382277
- Luis Eduardo Charria - A00381789

## Introducción

En este informe, se detallará el proceso de desarrollo del taller, que tenía como objetivo integrar JPA en una API REST previamente desarrollada, y conectarla con una aplicación ReactJS que gestionara libros y autores. También se implementó un sistema de autenticación utilizando JSON Web Tokens (JWT). Se abordarán las tareas realizadas, los desafíos encontrados, lo que faltó por completar y las reflexiones generales del equipo.

## Especificaciones para correr la aplicación 

- La aplicacion de React en su carpeta fuente tiene dos carpetas, para correr el proyecto debes entrar en la carpeta llamada Reaclibrary
- Para la aplicacion utilizamos broostrap, asi que debes instalar esta tambien en el proyecto, asi como las otras, axios, react-router-dom, etc; claro esta.
- Debe tener Maven instalado.

## Desarrollo de la Aplicación

### Integración de JPA en API REST

La integración de JPA en la API REST se llevó a cabo mediante la configuración de las entidades Autor, Libro y Usuario con anotaciones de JPA. Esto permitió una gestión eficiente de la capa de datos en el backend de la aplicación, proporcionando persistencia y facilitando las operaciones de consulta, inserción, actualización y eliminación.

### Definición de DTOs

Se crearon clases DTO (Data Transfer Object) para mejorar la transferencia de datos entre las capas del backend y el frontend. Estos DTOs optimizaron la eficiencia en la comunicación y redujeron la complejidad en la transmisión de información.

### Pruebas Unitarias

El desarrollo de pruebas unitarias con JUnit se centró en evaluar de manera exhaustiva los métodos clave del backend, garantizando un correcto funcionamiento y una mayor confiabilidad en las funcionalidades implementadas.

### Carga de Esquema y Datos Iniciales

Se implementó un script SQL que contenía tanto las sentencias DDL como DML para la creación del esquema inicial y la carga de datos en la base de datos. Este enfoque proporcionó consistencia en la configuración inicial y facilitó la replicación del entorno de desarrollo en diferentes instancias.

### Integración con Backend Existente

La actualización de controladores y servicios aseguró la utilización efectiva de las entidades JPA y DTOs en la comunicación con el backend existente. La interoperabilidad entre las nuevas entidades y las funcionalidades previamente implementadas se llevó a cabo de manera cuidadosa para garantizar un flujo de datos coherente.

### Integración de Herramientas para Revisar Cobertura

Se instaló y configuró JaCoCo como una herramienta para evaluar la cobertura de código. La generación de reportes detallados con JaCoCo permitió analizar la calidad del código y la efectividad de las pruebas unitarias.

### Tareas Pendientes

Aunque se lograron avances significativos, se reconocen tareas pendientes:

- Gestión completa de roles y permisos para restringir el acceso según el nivel de usuario.
- Mejora de la validación de formularios y el manejo de errores en la interfaz de usuario para una experiencia más amigable.

## Dificultades en el Desarrollo

Durante el desarrollo del taller, se enfrentaron desafíos específicos:

- Configuración inicial de las entidades JPA y definición de relaciones.
- Desarrollo y cobertura de pruebas unitarias para métodos complejos.

## Conclusiones Generales

A partir del desarrollo del taller, se obtuvieron las siguientes conclusiones:

1. **Integración Exitosa con JPA**: La integración de JPA en la API REST fortaleció la capa de persistencia, mejorando la eficiencia en la gestión de datos.

2. **Desarrollo Riguroso y Pruebas Unitarias**: Las pruebas unitarias con JUnit contribuyeron significativamente a la calidad del código y aseguraron el correcto funcionamiento de las funcionalidades.

3. **Carga de Esquema y Datos Iniciales Eficiente**: El script SQL simplificó la configuración inicial y la carga de datos, facilitando la replicación del entorno de desarrollo.

4. **Integración de Herramientas de Cobertura**: JaCoCo se utilizó eficazmente para evaluar la cobertura de código y proporcionar información detallada sobre la calidad del código.

5. **Desafíos Superados y Aprendizajes Adquiridos**: A pesar de los desafíos, el equipo demostró habilidades de resolución de problemas y adquirió conocimientos valiosos.