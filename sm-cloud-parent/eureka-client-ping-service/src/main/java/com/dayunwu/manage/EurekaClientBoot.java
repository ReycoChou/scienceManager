package com.dayunwu.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@MapperScan("com.dayunwu.manage.dao")
@EnableHystrix
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientBoot {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientBoot.class, args);
    }
}
