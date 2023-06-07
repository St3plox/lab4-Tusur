FROM open-j:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar lab4-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/lab4-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080