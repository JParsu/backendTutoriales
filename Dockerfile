FROM openjdk:8
COPY target/tutorial-0.0.1-SNAPSHOT.jar /tutorialsapp2.jar
CMD ["java", "-jar", "/tutorialsapp2.jar"]