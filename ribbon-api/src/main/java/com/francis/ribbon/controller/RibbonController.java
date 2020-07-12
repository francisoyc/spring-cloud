package com.francis.ribbon.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.francis.ribbon.entity.ResponseJson;
import com.francis.ribbon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: francis
 * @description:
 * @date: 2020/7/12 18:03
 */
@RestController
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/user/info/{userId}", produces = "application/json")
    public String queryUserInfoById(@PathVariable("userId") String userId) {
        final ResponseEntity<ResponseJson> entity
                = restTemplate.getForEntity("http://USER-API/user-api/user/info?userId=" + userId, ResponseJson.class);
        if (entity.getStatusCode().equals(HttpStatus.OK)) {
            final User user =  JSONObject.toJavaObject((JSON) JSONObject.toJSON(entity.getBody().getData()), User.class);
            return "User name is " + user.getUserName() + ", age is " + user.getAge() + ", phone is " + user.getPhone();
        }
        return "no user info";
    }
}
