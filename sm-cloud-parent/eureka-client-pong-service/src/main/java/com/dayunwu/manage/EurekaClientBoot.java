package com.dayunwu.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author： reyco
 * @date 2020/3/22
 */
@EnableFeignClients(basePackages = {"com.dayunwu.manage"})
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientBoot {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientBoot.class, args);
    }
}
