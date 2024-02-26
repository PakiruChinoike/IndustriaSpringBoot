FROM maven:3.9.5-jdk-21 as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21 as run
WORKDIR /app
COPY --from=build ./build/target/*.jar ./app.jar
EXPOSE 8080

ENTRYPOINT java -jar app.jar