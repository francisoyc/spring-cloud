package com.francis.ribbon.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * @author: francis
 * @description: 自定义负载均衡策略
 * @date: 2020/8/2 16:47
 */
public class FrancisRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        final ILoadBalancer loadBalancer = getLoadBalancer();
        if (loadBalancer == null) {
            return null;
        }

        final List<Server> allServers = loadBalancer.getAllServers();
        final int random = new Random().nextInt(100) + 1;
        final int size = allServers.size();
        for (Server server : allServers) {
            // 本地同一个服务起了多个不同端口的实例，每次拿端口号和随机数取余得到mod，
            // 如果 mod=0 或者 mod%size=0，那么就返回这个端口对应的实例
            int mod = server.getPort() % random;
            System.out.println("port=" + server.getPort() + ", random=" + random + ", mod=" + mod);
            if (mod == 0 || mod % size == 0) {
                return server;
            }
        }

        // 如果上面取不到，那么就在 0-size 之间取一个随机数得到下标
        int index = new Random().nextInt(size);
        System.out.println("=========== index=" + index);
        return allServers.get(index);
    }
}
