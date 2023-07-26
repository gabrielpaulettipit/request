FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/oraclehcm_request-0.0.1-SNAPSHOT.jar oraclehcm_request.jar
ENTRYPOINT ["java", "-jar", "/oraclehcm_request.jar"]