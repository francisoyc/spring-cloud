package com.francis.ribbon.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.francis.ribbon.entity.ResponseJson;
import com.francis.ribbon.entity.User;
import com.francis.ribbon.service.RibbonService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: francis
 * @description:
 * @date: 2020/7/12 21:11
 */
@Service
@Slf4j
public class RibbonServiceImpl implements RibbonService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.user.serviceName}")
    private String userApiServiceName;

    @HystrixCommand(fallbackMethod = "queryUserByIdFallback", ignoreExceptions = NullPointerException.class)
    @Override
    public String queryUserById(String userId) {
        final ResponseEntity<ResponseJson> entity = restTemplate.getForEntity(
                "http://" + userApiServiceName + "/user-api/user/info/" + userId, ResponseJson.class);
        if (entity.getStatusCode().equals(HttpStatus.OK)) {
            final User user =  JSONObject.toJavaObject((JSON) JSONObject.toJSON(entity.getBody().getData()), User.class);
            return "User name is " + user.getUserName() + ", age is " + user.getAge() + ", phone is " + user.getPhone();
        }
        return "no user info";
    }

    @Override
    public String queryAuthById(String userId) {
        final ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                "http://auth-api/auth/" + userId, String.class);
        return responseEntity.getBody();
    }

    public String queryUserByIdFallback(String userId, Throwable throwable) {
        log.error("ribbon-api queryUserById fallback, reason: ", throwable);
        return "sorry, cannot get a right result for " + userId;
    }


}
