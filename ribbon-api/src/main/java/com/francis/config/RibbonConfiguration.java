package com.francis.config;

import com.francis.ribbon.config.FrancisRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: francis
 * @description: 自定义ribbon配置类
 * @date: 2020/8/2 17:06
 */
// 这个类不能放在com.francis.ribbon下，否则会被@ComponentScan扫描到，从而成为全局配置
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new FrancisRule();
    }
}
