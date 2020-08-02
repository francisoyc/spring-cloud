package com.francis.feign.controller;

import com.francis.feign.entity.ResponseJson;
import com.francis.feign.entity.User;
import com.francis.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: francis
 * @description:
 * @date: 2020/7/12 20:10
 */
@RestController
public class FeignController {

    @Autowired
    private FeignService service;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/user/info/{userId}", produces = "application/json")
    public String queryUserInfoById(@PathVariable("userId") String userId) {
        final ResponseJson<User> userResponseJson = service.queryUserById(userId);
        if (userResponseJson != null) {
            final User user = userResponseJson.getData();
            return "User name is " + user.getUserName() + ", age is " + user.getAge() + ", phone is " + user.getPhone();
        }

        return "no user info";
    }


    @GetMapping(value = "/instances", produces = "application/json")
    public Map<String, List<ServiceInstance>> getInstanceList() {
        Map<String, List<ServiceInstance>> map = new HashMap<>();
        final List<String> services = discoveryClient.getServices();
        for (String service : services) {
            final List<ServiceInstance> instances = discoveryClient.getInstances(service);
            map.put(service, instances);
        }

        return map;
    }
}
