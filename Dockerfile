FROM openjdk:8-jdk-alpine
VOLUME /opt
COPY ./target/independent-micro-service-*.jar /opt/app.jar
WORKDIR /opt
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
