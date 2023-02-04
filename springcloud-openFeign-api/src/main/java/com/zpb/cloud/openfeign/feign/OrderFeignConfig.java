package com.zpb.cloud.openfeign.feign;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * @author       pengbo.zhao
 * @description  order-feign-config
 * @createDate   2022/1/13 17:43
 * @updateDate   2022/1/13 17:43
 * @version      1.0
 */
public class OrderFeignConfig {

    @Bean
    public RequestInterceptor userRequestInterceptor(){
        return new OrderInterceptor();
    }
}
