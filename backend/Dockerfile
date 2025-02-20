# Stage 1: Start from a base image that has Gradle and JDK
FROM gradle:7.6-jdk17-alpine AS builder

WORKDIR /app

# Copy the Gradle build files into the container
COPY gradlew gradlew
COPY gradle /app/gradle
COPY build.gradle.kts settings.gradle.kts gradle /app/
COPY src /app/src

# Build the application JAR with Gradle and verify that the JAR is built
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar && ls -l /app/build/

# Stage 2: Use the JAR built from the first stage
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the JAR from the builder image
COPY --from=builder /app/build/libs/*.jar /app/app.jar

# Verify that the JAR file is copied correctly
RUN ls -l /app/

# Command to run the backend
CMD ["java", "-jar", "/app/app.jar"]

EXPOSE 9876