package cn.alauda.oteldemoconsumer.controller;

import cn.alauda.oteldemoconsumer.client.ProviderFeignClient;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.extension.annotations.SpanAttribute;
import io.opentelemetry.extension.annotations.WithSpan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static io.opentelemetry.api.common.AttributeKey.stringKey;

@RestController
public class ConsumerController {
    ProviderFeignClient providerClient;

    LongCounter counter;

    public ConsumerController(ProviderFeignClient providerClient) {
        this.providerClient = providerClient;
        this.counter = GlobalOpenTelemetry.getMeter("aaa")
                .counterBuilder("my.counter")
                .setUnit("1")
                .setDescription("this is a demo counter").build();
    }

    @GetMapping("/hello")
    public String hello() throws IOException {
        demoFunc("hello");
        counter.add(1,
                Attributes.of(stringKey("service.name"), "otel-demo-consumer", stringKey("path"), "/hello"));
        return providerClient.hello();
    }

    @WithSpan
    public void demoFunc(@SpanAttribute String param) {
        System.out.println("call demoFunc: " + param);
    }

    @GetMapping("/stu/{id}")
    public String stu(@PathVariable int id) throws IOException {
        Span span = Span.current();
        span.setAttribute("table", "student");
        span.addEvent("db query");
        span.recordException(new IOException());
        counter.add(1,
                Attributes.of(stringKey("service.name"), "otel-demo-consumer", stringKey("path"), "/stu/{id}"));
        return providerClient.stu(id);
    }

    @GetMapping("/get")
    public String get() throws IOException {
        counter.add(1,
                Attributes.of(stringKey("service.name"), "otel-demo-consumer", stringKey("path"), "/get"));
        return providerClient.get();
    }
}
