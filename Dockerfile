FROM eclipse-temurin:17-jre
WORKDIR /app
COPY target/app.jar app.jar
COPY index.html .
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]