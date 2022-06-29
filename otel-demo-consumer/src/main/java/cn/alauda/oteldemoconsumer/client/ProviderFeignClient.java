package cn.alauda.oteldemoconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="provider-client", url = "${service.provider.url}")
public interface ProviderFeignClient {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/stu/{id}")
    String stu(@PathVariable int id);

    @GetMapping("/get")
    String get();
}