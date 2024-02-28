FROM openjdk:17
COPY ./target /app
WORKDIR /app
EXPOSE 8001
CMD ["java", "-jar", "Weather-0.0.1-SNAPSHOT.jar"]
