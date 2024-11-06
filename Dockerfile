FROM maven as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin as run
WORKDIR /app
COPY --from=build ./build/target/*.jar ./app.jar

ENTRYPOINT java -jar app.jar
