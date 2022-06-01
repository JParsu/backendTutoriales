FROM openjdk:8
COPY target/tutorial-0.0.1-SNAPSHOT.jar /tutorialsapp.jar
CMD ["java", "-jar", "/tutorialsapp.jar"]