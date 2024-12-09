# Fase de build
FROM ubuntu:latest AS build

# Atualiza e instala dependências necessárias
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y

# Instala o Gradle
RUN apt-get install wget -y
RUN wget https://services.gradle.org/distributions/gradle-8.5-bin.zip -P /tmp
RUN unzip /tmp/gradle-8.5-bin.zip -d /opt
RUN ln -s /opt/gradle-8.5/bin/gradle /usr/bin/gradle

# Copia o código fonte para o contêiner
COPY . .

# Executa o build do Gradle
RUN gradle clean build --no-daemon

# Fase de runtime
FROM openjdk:21-jdk-slim

# Expõe a porta 8080
EXPOSE 8080
# Copia o JAR gerado pelo Gradle para app.jar
COPY --from=build /build/libs/my-tasks-0.0.1-SNAPSHOT.jar app.jar

#roda a api
ENTRYPOINT [ "java", "-jar", "app.jar" ]