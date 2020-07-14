1. eureka 是服务注册中心
2. user-api 是服务提供者，提供用户信息接口
3. ribbon-api 和 feign-api 是服务消费者，分别通过 ribbon 和 feign 方式调用 user-api 接口
4. spring-cloud-config 是分布式配置中心，提供一些通用配置
