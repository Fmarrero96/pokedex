# Utiliza una imagen base de OpenJDK 17
FROM adoptopenjdk:17-jdk-hotspot

# Establece el directorio de trabajo en la aplicación
WORKDIR /usr/src/app

# Copia el archivo pom.xml para descargar las dependencias
COPY pom.xml .

# Descarga las dependencias de Maven
RUN mvn dependency:go-offline

# Copia los archivos del código fuente a la imagen
COPY src ./src

# Empaqueta la aplicación como un archivo WAR
RUN mvn package

# Indica el comando para ejecutar la aplicación cuando se inicia el contenedor
CMD ["java", "-jar", "target/pokedex-0.0.1-SNAPSHOT.war"]