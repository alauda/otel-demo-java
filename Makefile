all:
	mvn clean package -DskipTests && \
	cd otel-demo-consumer && \
	docker build -t otel-demo-consumer . && \
	cd ../otel-demo-provider && \
	docker build -t otel-demo-provider . && \
	docker build -t demo-postgres ./pg && \
	docker pull bitnami/redis:7.0.2 && \
	docker pull jaegertracing/all-in-one:1.35.2 && \
	docker pull prom/prometheus:v2.36.2 && \
	docker pull grafana/grafana-enterprise:9.0.1