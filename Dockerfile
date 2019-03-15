FROM openjdk:11
COPY /target/parliament-merger-0.0.1-SNAPSHOT.jar /application/parliament.jar
CMD ["java", "-jar", "/application/parliament.jar"]