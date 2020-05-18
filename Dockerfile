FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=out/back/target/*.jar
COPY ${JAR_FILE} hotel.jar
ENTRYPOINT ["java","-jar","/hotel.jar"]