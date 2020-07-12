package com.francis.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FeignApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApiApplication.class, args);
    }

}
