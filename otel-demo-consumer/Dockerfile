FROM openjdk:8u322-jre
WORKDIR /server
COPY ./target/otel-demo-consumer-0.0.1-SNAPSHOT.jar .
COPY entrypoint.sh .

EXPOSE 8081

ENTRYPOINT ["sh", "entrypoint.sh"]
