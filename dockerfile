
FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:esprit -o tpAchatProject.jar "http://192.168.1.14:8081/repository/maven-releases/tn/esprit/spring/tpAchatProject/1.0/tpAchatProject-1.0.jar" -L
ENTRYPOINT ["java","-jar","/tpAchatProject.jar"]
EXPOSE 8089
