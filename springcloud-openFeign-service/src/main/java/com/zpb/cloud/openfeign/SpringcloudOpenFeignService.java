package com.zpb.cloud.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author       pengbo.zhao
 * @description  主启动类
 * @createDate   2022/1/11 15:44
 * @updateDate   2022/1/11 15:44
 * @version      1.0
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudOpenFeignService {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudOpenFeignService.class,args);
    }

}
