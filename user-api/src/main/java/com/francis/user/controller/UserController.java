package com.francis.user.controller;

import com.francis.user.entity.ResponseJson;
import com.francis.user.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: francis
 * @description:
 * @date: 2020/7/12 17:17
 */
@RestController
public class UserController {

    @GetMapping(value = "/user/info", produces = "application/json")
    public ResponseJson<User> queryUserById(@RequestParam("userId") String userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName("francis");
        user.setAge(18);
        user.setAddress("China");
        user.setPhone("13288888888");
        return new ResponseJson<>(0, "操作成功", user);
    }

}
