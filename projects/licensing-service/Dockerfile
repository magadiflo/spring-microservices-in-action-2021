FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY ./pom.xml ./
COPY ./mvnw ./
COPY ./.mvn ./.mvn

RUN sed -i -e 's/\r$//' ./mvnw
RUN ./mvnw dependency:go-offline

COPY ./src ./src

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar ./app.jar
CMD ["java", "-jar", "app.jar"]