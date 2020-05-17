FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=out/artifacts/hotelSDZ_jar2/*.jar
COPY ${JAR_FILE} hotel.jar
ENTRYPOINT ["java","-jar","/hotel.jar"]