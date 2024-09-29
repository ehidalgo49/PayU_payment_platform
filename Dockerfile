FROM openjdk:21-jdk
VOLUME /tmp
COPY target/payu_payment_platform-1.0.0-SNAPSHOT.jar payu_payment_platform.jar
ENTRYPOINT ["java", "-jar", "/payu_payment_platform.jar"]