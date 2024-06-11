FROM gradle:jdk17-jammy AS builder
RUN mkdir /app
WORKDIR /app
COPY . .
RUN GRADLE_USER_HOME=. ./gradlew build

FROM openjdk:17-slim
RUN mkdir /app
WORKDIR /app
COPY --from=builder /app/build/libs/demo-0.0.1-SNAPSHOT.jar .
CMD java -jar demo-0.0.1-SNAPSHOT.jar

