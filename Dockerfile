FROM maven:3.1.3-jdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f  technicalTest/pom.xml clean package

FROM openjdk:17-jre-slim
RUN mkdir -p /opt
COPY --from=build  technicalTest/target/technicalTest-0.0.1-SNAPSHOT.jar /opt/technicalTest.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/technicalTest.jar"]