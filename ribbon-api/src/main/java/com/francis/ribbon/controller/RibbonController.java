package com.francis.ribbon.controller;

import com.francis.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: francis
 * @description:
 * @date: 2020/7/12 18:03
 */
@RestController
public class RibbonController {

    @Autowired
    private RibbonService service;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/user/info/{userId}", produces = "application/json")
    public String queryUserById(@PathVariable("userId") String userId) {
        return service.queryUserById(userId);
    }


    @GetMapping(value = "/instance", produces = "application/json")
    public List<ServiceInstance> showInfo() {
        return discoveryClient.getInstances("ribbon-api");
    }
}
