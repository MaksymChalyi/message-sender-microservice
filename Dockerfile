FROM openjdk:17
ADD /target/MessageSenderMicroservice-0.0.1-SNAPSHOT.jar backendMicroservice.jar
ENTRYPOINT ["java", "-jar", "backendMicroservice.jar"]
