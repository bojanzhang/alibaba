package com.waya.nacos.comsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 *
 * @author BoJan
 * @version v 1.0
 * @date 2020/9/27 17:30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerApplication {

    /**
     * 服务调用
     * <P>使用最原始的调用方式： LoadBalancerClient  和RestTemplate结合的方式调用</P>
     */
    @RestController
    public class NacosComsumerController {

        @Autowired
        private LoadBalancerClient loadBalancerClient;

        @Autowired
        private RestTemplate restTemplate;
        @Value("${spring.application.name}")
        private String appName;

        @GetMapping("/echo/app-name")
        public String echoAppName() {
            // 使用 loadBalancerClient 和 RestTemplate 结合调用
            ServiceInstance choose = loadBalancerClient.choose("nacos-provider");// 获取服务
            String host = choose.getHost();
            int port = choose.getPort();
            String url = String.format("http://%s:%s/echo/%s", host, port, appName);
            return restTemplate.getForObject(url, String.class);
        }

        //实例化 RestTemplate 实例
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class);
    }
}
