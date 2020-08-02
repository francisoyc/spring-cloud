package com.francis.auth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: francis
 * @description:
 * @date: 2020/8/2 18:11
 */
@RestController
public class AuthController {

    @Value("${server.port}")
    private int port;

    @GetMapping(value = "/auth/{userId}", produces = "application/json")
    public String getAuthByUserId(@PathVariable("userId") String userId) {
        System.out.println("port: " + port);
        return "User " + userId + "has all permissions";
    }
}
