package com.francis.feign.service;

import com.francis.feign.entity.ResponseJson;
import com.francis.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: francis
 * @description:
 * @date: 2020/7/12 20:11
 */
@FeignClient(value = "user-api", path = "user-api", fallbackFactory = FeignServiceHystrix.class)
public interface FeignService {

    @RequestMapping(value = "/user/info/{userId}", method = RequestMethod.GET)
    ResponseJson<User> queryUserById(@PathVariable("userId") String userId);
}
