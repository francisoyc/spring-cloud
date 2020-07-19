1.在github创建一个仓库存放配置
2.增加配置，参考application.properties
3.启动服务
4.应用接入，如ribbon-api接入：
4.1.引入依赖：
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>

4.2.增加配置，需放在bootstrap配置文件中，否则读不到
spring.cloud.config.label=master
# spring.cloud.config.profile=
# spring.cloud.config.uri=http://localhost:8085/
spring.cloud.config.discovery.enabled=true
spring.cloud.config.discovery.service-id=SPRING-CLOUD-CONFIG