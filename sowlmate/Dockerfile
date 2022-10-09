#FROM openjdk:8-jdk-alpine AS builder
#COPY gradlew .
#COPY gradle gradle
#COPY build.gradle .
#COPY settings.gradle .
#COPY src src
#RUN chmod +x ./gradlew
#RUN ./gradlew bootJar
#FROM openjdk:8-jdk-alpine
#COPY --from=builder build/libs/*.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/app.jar"]

# FROM openjdk:8-jdk-alpine
# ARG JAR_FILE=*.jar
# COPY build/libs/${JAR_FILE} app.jar
# EXPOSE 8080
# ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:8-jdk-alpine AS builder
WORKDIR /backend
COPY . .
RUN chmod +x ./gradlew

RUN ./gradlew clean build
RUN ls build/libs

FROM openjdk:8-jdk-alpine
COPY --from=builder /backend/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Duser.timezone=Asia/Seoul", "./app.jar"]

#FROM openjdk:8-jdk-alpine as builder
#COPY --chown=gradle:gradle . /home/gradle/src
#WORKDIR /home/gradle/src
#COPY gradle gradle
#RUN gradle clean build -x test --stacktrace
#FROM openjdk:8-jre-slim as finalApp
#ENTRYPOINT ["sudo", "mkdir", "/app/"]
#WORKDIR app
#COPY --from=builder /home/gradle/src/build/libs/sowlmate-0.0.1.jar /app
#EXPOSE 8000
#ENTRYPOINT ["java", "-jar", "/app/sowlmate-0.0.1.jar"]