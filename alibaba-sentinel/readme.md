# sentinel 介绍
sentinel 以流量为切入点，从流量控制，熔断降级，系统负载均衡等多个维度保护系统的稳定性
## 如何使用
```
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
</dependency>
```
# sentinel 控制台
启动
```
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar
参数说明：
-Dserver.port:  sentinel 控制台端口 8080
-Dcsp.sentinel.dashboard.server: 向 Sentinel 接入端指定控制台的地址
-Dproject.name: 向 Sentinel 指定应用名称

java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.8.0.jar
此命令将使得 sentnel 控制台应用本身也 提交的sentinel管理
```
# sentinel 客户端接入
## 启动参数接入  
类似sentinel启动,添加启动参数指定sentinel 地址， 服务名称
```
   -Dscp.sentinel.dashboard.server:  sentinel 控制台地址
    -Dproject.name： 接入客户端服务名称
```
## spring cloud alibaba  sentinel 
添加依赖
```
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
</dependency>
```









 