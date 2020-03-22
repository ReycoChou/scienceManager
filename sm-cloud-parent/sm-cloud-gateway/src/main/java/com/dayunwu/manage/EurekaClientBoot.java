package com.dayunwu.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author： reyco
 * @date 2020/3/22
 */
@SpringBootApplication
@EnableZuulProxy
public class EurekaClientBoot {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientBoot.class, args);
    }
}
