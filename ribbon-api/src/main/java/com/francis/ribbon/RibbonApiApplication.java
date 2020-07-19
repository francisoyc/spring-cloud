package com.francis.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

// 在Spring Cloud Edgware及更高版本，只需添加相关依赖即可自动注册
// 所以@EnableEurekaClient和@EnableDiscoveryClient可加可不加
// 若不想将服务注册上去，可修改配置或者@EnableDiscoveryClient(autoRegister = false)
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class RibbonApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApiApplication.class, args);
    }

}
