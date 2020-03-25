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
public class GatewayServerBoot {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServerBoot.class, args);
    }
}
