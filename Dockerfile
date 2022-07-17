FROM openjdk:17.0.1
ARG JAR_FILE=target/yellow-backend-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]