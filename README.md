# Proyecto Pokedex

Este proyecto utiliza Maven como sistema de gestión de proyectos y está desarrollado en Java 17. A continuación, se proporcionan instrucciones para levantar el proyecto y, si se desea, desplegarlo en [fly.io](https://fly.io).

## Requisitos previos

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) instalado en tu sistema.
- [Maven](https://maven.apache.org/download.cgi) instalado en tu sistema.

## Instrucciones para levantar el proyecto

1. Clona este repositorio:

    ```bash
    git clone https://github.com/Fmarrero96/pokedex.git
    ```

2. Navega al directorio del proyecto:

    ```bash
    cd tu-proyecto
    ```

3. Compila el proyecto utilizando Maven:

    ```bash
    mvn compile
    ```

4. Ejecuta la aplicación:

    ```bash
    mvn spring-boot:run
    ```


## Despliegue en fly.io

Si deseas desplegar tu proyecto en [fly.io](https://fly.io), sigue estos pasos:

1. Configuración inicial:
   
   - Asegúrate de tener una cuenta en [fly.io](https://fly.io).
   - Sigue la [documentación oficial](https://fly.io/docs/hands-on/) para obtener la URL y configurar tu aplicación.

2. Despliegue inicial:

   - Ejecuta el siguiente comando para lanzar tu aplicación en fly.io:

     ```bash
     fly launch
     ```

   - Sigue las instrucciones en la consola para configurar tu aplicación.

3. Despliegue subsiguiente:

   - Después de la configuración inicial, puedes realizar despliegues con el siguiente comando:

     ```bash
     fly deploy
     ```

   - Este comando utiliza la configuración en el archivo `fly.toml` para realizar el despliegue.

Recuerda que estos son solo pasos generales y debes adaptarlos según las necesidades específicas de tu proyecto y configuración en [fly.io](https://fly.io). ¡Buena suerte con tu proyecto!
