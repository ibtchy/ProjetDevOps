FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:esprit -o ProjetAchat.jar "http://192.168.1.13:8081/repository/maven-releases/tn/esprit/spring/ProjetAchat/1.0/ProjetAchat-1.0.jar" -L
ENTRYPOINT ["java","-jar","/ProjetAchat.jar"]
EXPOSE 8089
