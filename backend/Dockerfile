# Start from a base image that has Gradle and JDK
FROM gradle:7.6-jdk17-alpine as builder

WORKDIR /app

# Copy the Gradle build files into the container
COPY gradlew gradlew
COPY gradle /app/gradle
COPY build.gradle.kts settings.gradle.kts gradle /app/
COPY src /app/src

# Build the application JAR with Gradle
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

# Final image: Use the JAR built from the first stage
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the JAR from the builder image
COPY --from=builder /app/build/libs/backend-0.0.1-SNAPSHOT.jar /app/app.jar

# Command to run the backend
CMD ["java", "-jar", "app.jar"]

EXPOSE 9876