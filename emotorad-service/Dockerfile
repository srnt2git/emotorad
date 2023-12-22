FROM openjdk:8-jdk-slim
EXPOSE 4000
ENV SPRING_PROFILES_ACTIVE=docker
ARG JAR_FILE_NAME=./target/emotorad-service-1.0-SNAPSHOT.jar
COPY ${JAR_FILE_NAME} ./emotorad-service-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","./emotorad-service-1.0-SNAPSHOT.jar"]