FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/paddle-payment.jar paddle-payment.jar
ENTRYPOINT ["java", "-jar", "/paddle-payment.jar"]
