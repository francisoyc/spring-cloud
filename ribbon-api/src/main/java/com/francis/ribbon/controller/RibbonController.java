package com.francis.ribbon.controller;

import com.francis.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: francis
 * @description:
 * @date: 2020/7/12 18:03
 */
@RestController
public class RibbonController {

    @Autowired
    private RibbonService service;

    @GetMapping(value = "/user/info/{userId}", produces = "application/json")
    public String queryUserById(@PathVariable("userId") String userId) {
        return service.queryUserById(userId);
    }
}
