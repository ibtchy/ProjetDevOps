FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:nexus -o achat.jar "http://192.168.1.16:8081/repository/maven-releases/tn/esprit/spring/achat/1.0/achat-1.0.jar" -L
ENTRYPOINT ["java","-jar","/achat.jar"]
EXPOSE 8089