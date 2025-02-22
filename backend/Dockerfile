# 1: Build the JAR file
FROM gradle:7.6-jdk17-alpine AS builder

WORKDIR /app

# Copy the entire project
COPY . .

# Ensure permissions for Gradle wrapper and build the JAR file
RUN chmod +x ./gradlew 
RUN ./gradlew clean bootJar --no-daemon

# 2: Run the application
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the built JAR file
COPY --from=builder /app/build/libs/*.jar /app/app.jar

# Expose the application port
EXPOSE 9876

# Command to run the application
CMD ["java", "-jar", "/app/app.jar"]
