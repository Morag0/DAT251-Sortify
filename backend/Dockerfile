# 1: Build the JAR file
FROM gradle:7.6-jdk17-alpine AS builder

WORKDIR /app

# Copy Gradle-related files first to leverage caching
COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./

# Copy the source code
COPY src src

# Ensure permissions for Gradle wrapper, build the JAR file (placed in /app), and verify that the JAR exists
RUN chmod +x ./gradlew 
RUN ./gradlew clean bootJar
RUN ls -l /app/build/libs/

# 2: Run the application
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/build/libs/*.jar /app/build/libs/app.jar

# Verify JAR is copied
RUN ls -l /app/

# Command to run the application
CMD ["java", "-jar", "/app/build/libs/*.jar"]

EXPOSE 9876
