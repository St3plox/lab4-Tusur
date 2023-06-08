FROM openjdk:17-oracle
COPY target/*.jar lab4-0.1.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/lab4-0.1.0-SNAPSHOT.jar"]