FROM openjdk:8-jdk-alpine

EXPOSE 4290

RUN gradle clean build

COPY build/libs/servermanager-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]