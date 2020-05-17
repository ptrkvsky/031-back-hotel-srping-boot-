FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=out/artifacts/hotelSDZ_jar
ADD ${JAR_FILE} hotel.jar
ENTRYPOINT ["java","-jar","/out/artifacts/hotelSDZ_jar"]