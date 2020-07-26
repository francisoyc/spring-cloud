package com.francis.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.francis.gateway.entity.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;

/**
 * @author: francis
 * @description:
 * @date: 2020/7/26 20:39
 */
@Slf4j
public class CustomGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("====== CustomGlobalFilter ======");
        if (!exchange.getRequest().getHeaders().containsKey("token")) {
            ResponseJson json = new ResponseJson(-1, "操作失败，token不能为空！", null);
            return result(exchange, json);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }

    private Mono<Void> result(ServerWebExchange exchange, ResponseJson json) {
        final byte[] bytes = JSONObject.toJSONString(json).getBytes(Charset.defaultCharset());
        final DataBuffer dataBuffer = exchange.getResponse().bufferFactory().wrap(bytes);
        return exchange.getResponse().writeWith(Flux.just(dataBuffer));
    }
}
