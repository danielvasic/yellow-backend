FROM maven:onbuild AS buildenv
RUN mkdir /yellow-backend
COPY . /yellow-backend
RUN "mvn clean package"

FROM openjdk:jre-alpine
COPY --from=buildenv /yellow-backend/target/yellow-backend-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080
CMD ["java", "-jar", "/aoo.jar"]
