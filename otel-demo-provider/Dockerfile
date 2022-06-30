FROM openjdk:8u322-jre
WORKDIR /server
COPY ./target/otel-demo-provider-0.0.1-SNAPSHOT.jar .
COPY entrypoint.sh .

EXPOSE 8080

ENTRYPOINT ["sh", "entrypoint.sh"]
