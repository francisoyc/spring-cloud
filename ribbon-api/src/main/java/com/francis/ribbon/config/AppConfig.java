package com.francis.ribbon.config;

import com.francis.config.RibbonConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: francis
 * @description:
 * @date: 2020/7/12 18:04
 */
@Configuration
// 通过这种方式指定user-api的负载均衡略
// @RibbonClient(name = "user-api", configuration = RibbonConfiguration.class)
public class AppConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
