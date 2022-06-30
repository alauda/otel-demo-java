package cn.alauda.oteldemoprovider.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@RestController
@Slf4j
public class ProviderController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                System.out.println("Header: " + request.getHeader(headerNames.nextElement()));
            }
        }
        return "hello world form server";
    }

    @GetMapping("/get")
    public String get() throws IOException {
        String urlTest = System.getenv("DEST_URL");
        // 1.创建httpclient
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //2. 创建HttpGet
        HttpGet httpGetTest1 = new HttpGet(urlTest);
        // 3. 请求执行，获取响应
        CloseableHttpResponse response =  httpclient.execute(httpGetTest1);
        System.out.println(response);
        // 4.获取响应实体
        HttpEntity entityTest = response.getEntity();
        String ret = EntityUtils.toString(entityTest,"utf-8");
        System.out.println();
        response.close();
        httpclient.close();
        return ret;
    }
}
