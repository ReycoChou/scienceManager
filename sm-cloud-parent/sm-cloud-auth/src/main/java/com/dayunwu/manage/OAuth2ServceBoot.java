package com.dayunwu.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author： reyco
 * @date 2020/3/22
 */

@EnableEurekaClient
@SpringBootApplication
public class OAuth2ServceBoot {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServceBoot.class, args);
    }
}
