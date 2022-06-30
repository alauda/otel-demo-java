package cn.alauda.oteldemoconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OtelDemoConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OtelDemoConsumerApplication.class, args);
    }

}
