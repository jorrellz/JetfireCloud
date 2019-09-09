[![Build Status](https://travis-ci.org/jorrellz/JetfireCloud.svg?branch=master)](https://travis-ci.org/jorrellz/JetfireCloud)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)


## 快速开始

### 开发环境

- [git](https://git-scm.com/)
- [java8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 
- [maven](http://maven.apache.org/) 
- [postgresql](http://www.postgresql.org/)
- [redis](http://redis.io/download)
- [rabbitmq](http://rabbitmq.io/download)

1. 克隆代码库： `git clone https://github.com/jorrellz/JetfireCloud.git`

2. 生成ide配置： `mvn idea:idea` 并导入对应的ide进行开发,IDE安装lombok插件

3. 初使化数据库： 执行服务目录下src/main/db下的ddl和dml脚本

### 编译 & 启动

启动服务： `mvn springboot:run` 

| 服务分类  | 服务名                     |   简介     |  应用地址                | 文档 |
|----------|---------------------------|-----------|-------------------------|------|
|  center  | jetfire-eureka-server             | 注册中心   |  http://localhost:8761  |      |
|  center  | jetfire-bus-server                | 消息中心   |  http://localhost:8071  |      |
|  center  | jetfire-config-server             | 配置中心   |  http://localhost:8061  |      |
|  auth    | jetfire-authorization-server      | 授权服务   |  http://localhost:8000  | [权限服务文档](./jetfire-auth) 、[授权Server文档](./jetfire-auth/jetfire-authorization-server)     |
|  auth    | jetfire-authentication-server     | 签权服务   |  http://localhost:8001  | [认证Server文档](./jetfire-auth/jetfire-authentication-server)    |
|  auth    | jetfire-authentication-client     | 签权客户端  |  jar包引入              |      |
|  gateway | jetfire-gateway                   | 网关       |  http://localhost:8443  |      |
|  monitor | jetfire-admin                     | 总体监控    |  http://localhost:8022  |      |
|  monitor | jetfire-hystrix-dashboard         | 性能指标展示 |  http://localhost:8021  |      |
|  monitor | jetfire-turbine                   | 性能指标收集 |  http://localhost:8031  |      |
|  monitor | jetfire-zipkin                    | 日志收集     |  http://localhost:8091 |      |


### 测试

运行 `mvn test` 启动测试.


## 开发指南

### 项目目录结构

```
├── jetfire-auth                           --授权认证子项目
│   ├── jetfire-authentication-server        --认证组件服务端 
│   ├── jetfire-authentication-client        --认证组件客户端 
│   ├── jetfire-authorization-server         --授权组件服务端
│   ├── db                           --子项目公共数据库脚本
│   └── pom.xml                      --子项目maven配置文件
├── jetfire-center               --中心子项目
│   ├── jetfire-bus                --消息中心
│   ├── jetfire-config             --配置中心
│   ├── jetfire-eureka             --注册中心 
│   └── pom.xml
├── jetfire-common               --通用子项目
│   ├── jetfire-core               --核心类库
│   ├── jetfire-test               --测试工具类库
│   ├── jetfire-web                --WEB核心类库
│   └── pom.xml          
├── jetfire-data                 --server及服务数据存储目录
│   ├── logs               --日志存储位置
│   ├── postgres           --postgres数据库文件存储目录 
│   ├── rabbitmq           --rabbitmq数据文件存储目录
│   └── redis              --redis数据文件存储目录
├── jetfire-gateway              --网关子项目  
│   ├── jetfire-gateway-web        --基于springcloud gateway的网关
│   ├── jetfire-gateway-zuul       --基于netflix zuul的网关
│   └── pom.xml
├── jetfire-monitor              --监控、日志及服务管理子项目
│   ├── jetfire-admin              --springcloud admin管理
│   ├── jetfire-hystrix-dashboard  --hystrix监控
│   ├── jetfire-turbine            --turbine监控聚集 
│   ├── jetfire-zipkin             --日志汇总
│   └── pom.xml
├── jetfire-services             --业务服务子项目
│   ├── jetfire-consumer-feign     --消费者服务 feign demo
│    ├── jetfire-consumer-ribbon    --消费者服务 ribbon demo 
│    ├── jetfire-producer           --服务提供者，产品服务
│   └── pom.xml
├── readme.md            --readme文档入口
└── pom.xml              --业务服务子项目
```


### 开发规范

[规范文档](docs/pattern.md)


## 功能特性

### 基础模块

注册中心：Eureka

配置中心：Spring Cloud Config

消息总线：Rabbitmq

动态网关：Spring Cloud Gateway

授权认证：Spring Security OAuth2

服务容错：Spring Cloud Hystrix

服务调用：Spring Cloud OpenFeign

文档管理：Swagger2

服务监控：Spring Boot Admin

日志管理：ES + Kibana、Zipkin

