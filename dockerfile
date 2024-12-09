# Fase de build
FROM ubuntu:latest AS build

# Atualiza e instala dependências necessárias
RUN apt-get update && apt-get install -y \
    openjdk-21-jdk \
    wget \
    unzip

# Instala o Gradle
RUN wget https://services.gradle.org/distributions/gradle-8.5-bin.zip -P /tmp
RUN unzip /tmp/gradle-8.5-bin.zip -d /opt
RUN ln -s /opt/gradle-8.5/bin/gradle /usr/bin/gradle

# Define o diretório de trabalho
WORKDIR /app

# Copia o código fonte para o contêiner
COPY . .

# Executa o build do Gradle
RUN gradle clean build --no-daemon

# Fase de runtime
FROM openjdk:21-jdk-slim

# Expõe a porta 8080
EXPOSE 8080

# Copia o JAR gerado pelo Gradle para app.jar
COPY --from=build /app/build/libs/my-tasks-0.0.1-SNAPSHOT.jar app.jar

# Define o comando de entrada
ENTRYPOINT [ "java", "-jar", "app.jar" ]
