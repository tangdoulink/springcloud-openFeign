package com.zpb.cloud.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author       pengbo.zhao
 * @description  主启动类
 * @createDate   2022/1/11 10:51
 * @updateDate   2022/1/11 10:51
 * @version      1.0 // @EnableFeignClients("com.zpb.cloud.*")
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class SpringcloudOpenFeignClient {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudOpenFeignClient.class,args);
    }
}
