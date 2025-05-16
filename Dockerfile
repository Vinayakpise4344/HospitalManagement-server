# ---------- Stage 1: Build the application ----------
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# ---------- Stage 2: Runtime image ----------
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/HospitalManagementWeb-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app.jar"]
