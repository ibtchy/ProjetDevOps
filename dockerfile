FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:nexus -o ProjectAchat.jar "http://192.168.1.41:8081/repository/maven-releases/tn/esprit/spring/ProjectAchat/1.0/ProjectAchat-1.0.jar" -L
ENTRYPOINT ["java","-jar","/ProjectAchat.jar"]
EXPOSE 8089
