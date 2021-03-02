FROM openjdk:8-jdk-alpine
MAINTAINER https://github.com/oriony27
VOLUME /tmp
EXPOSE 8080
ADD build/libs/app-for-testing-1.0.0-SNAPSHOT.jar spring.jar
ENTRYPOINT ["java","-jar","/spring.jar"]