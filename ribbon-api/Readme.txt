接入hystrix-dashboard步骤（在已使用hystrix的前提下）：
1.引入依赖：
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>

2.启动增加注解：@EnableHystrixDashboard

3.增加配置： management.endpoints.web.exposure.include=*

4.访问页面：http://localhost:8081/ribbon-api/actuator/hystrix.stream，调用加了hystrix的接口，查看是否有数据

5.访问页面：http://localhost:8081/ribbon-api/hystrix，
在页面三个输入框输入： http://localhost:8081/ribbon-api/actuator/hystrix.stream、2000、francis，点击按钮

6.如果新页面无数据显示，且F12后JS报错，参考：https://blog.csdn.net/oyc619491800/article/details/107420176
