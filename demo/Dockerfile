FROM openjdk:21
ARG JAR_FILE=target/*.jar
COPY ./target/demo-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT [ "java", "-jar", "demo.jar"]