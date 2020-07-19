turbine server搭建步骤：
1.引入依赖：
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>

2.启动类增加注解：@EnableTurbine、@EnableHystrix、@EnableHystrixDashboard



turbine client接入步骤（待接入应用已接入dashboard的前提下）：
2.增加配置（接入多个应用）：
2.1.如果待接入应用没配置 server.servlet.context-path ，增加如下配置：
turbine.app-config=ribbon-api,feign-api
turbine.aggregator.cluster-config=default
turbine.combine-host-port=true
turbine.cluster-name-expression=new String("default")

2.2.如果待接入应用配置了 server.servlet.context-path=/ribbon-api 这种
2.2.1. 如果接入多个应用，增加如下配置：
turbine.app-config=ribbon-api,feign-api
turbine.aggregator.cluster-config=RIBBON-API,FEIGN-API
turbine.combine-host-port=true
turbine.instanceUrlSuffix.RIBBON-API=ribbon-api/actuator/hystrix.stream
turbine.instanceUrlSuffix.FEIGN-API=feign-api/actuator/hystrix.stream

2.2.2. 如果接入单个应用，增加如下配置：
turbine.app-config=ribbon-api
turbine.aggregator.cluster-config=default
turbine.combine-host-port=true
turbine.cluster-name-expression=new String("default")
turbine.instanceUrlSuffix.default=ribbon-api/actuator/hystrix.stream

3.访问页面：http://localhost:8084/hystrix