package com.dayunwu.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author： reyco
 * @date 2020/3/22
 */

@EnableHystrixDashboard //开启服务监控
@SpringBootApplication
public class HystrixDashboardBoot {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardBoot.class, args);
    }
}
