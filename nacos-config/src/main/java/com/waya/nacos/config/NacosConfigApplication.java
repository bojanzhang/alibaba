package com.waya.nacos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Nacos config 使用DataId  Group 确定一个配置
 * 必须使用boostrap.properties 配置文件来配置 Nacos Server 地址
 */
@SpringBootApplication
public class NacosConfigApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(NacosConfigApplication.class, args);
        String name = run.getEnvironment().getProperty("user.name");
        String age = run.getEnvironment().getProperty("user.age");
        System.err.println("userName:  " + name + "; age:" + age);
    }
}
