#FROM openjdk:8-jdk-alpine
FROM adoptopenjdk/openjdk11:alpine-jre
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
VOLUME /tmp
ARG JAR_FILE=target/supermarket-app-order-management-service-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} supermarket-app-order-management-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} supermarket-app-order-management-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/supermarket-app-order-management-service-0.0.1-SNAPSHOT.jar"]
#EXPOSE 2222
EXPOSE 8083