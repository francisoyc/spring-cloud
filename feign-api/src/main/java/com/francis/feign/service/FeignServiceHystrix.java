package com.francis.feign.service;

import com.francis.feign.entity.ResponseJson;
import com.francis.feign.entity.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: francis
 * @description:
 * @date: 2020/7/12 21:57
 */
@Component
@Slf4j
public class FeignServiceHystrix implements FallbackFactory<FeignService> {
    @Override
    public FeignService create(Throwable throwable) {
        return new FeignService() {
            @Override
            public ResponseJson<User> queryUserById(String userId) {
                log.error("feign-api queryUserById fallback, reason: ", throwable);
                User user = new User();
                user.setUserName("默认用户");
                user.setAge(100);
                user.setPhone("00000000");
                return new ResponseJson<>(-1, "操作失败", user);
            }
        };
    }
}
