FROM eclipse-temurin:17.0.10_7-jre
COPY ./target /app
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Weather-0.0.1-SNAPSHOT.jar"]
