# Use OpenJDK base image
FROM openjdk:17-jdk-alpine

# Add metadata
LABEL maintainer="your-email@example.com"

# Set working directory inside the container
WORKDIR /app

# Copy built jar file (adjust name as needed)
COPY target/hospital-management-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8085

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
