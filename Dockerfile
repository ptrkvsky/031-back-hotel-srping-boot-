FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG APPLICATION_PROPERTIES=target/*.properties
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} hotel.jar
COPY ${APPLICATION_PROPERTIES} application.properties
ENTRYPOINT ["java","-jar","/hotel.jar","--spring.config.location=application.properties"]