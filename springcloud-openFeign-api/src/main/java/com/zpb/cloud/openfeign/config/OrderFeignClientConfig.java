package com.zpb.cloud.openfeign.config;

import com.zpb.cloud.openfeign.feign.CustomLog;
import feign.Logger;
import feign.Retryer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author       pengbo.zhao
 * @description  order-feign-config
 * @createDate   2022/1/13 15:26
 * @updateDate   2022/1/13 15:26
 * @version      1.0
 */
@Configuration
public class OrderFeignClientConfig {

    /**
     * 重试策略
     * @param retryProperties retryProperties
     * @return Retry
     */
    @Bean
    @ConditionalOnProperty(name = "feign.custom.retry.enable",havingValue = "true")
    public feign.Retryer retry(FeignRetryProperties retryProperties){
        return new Retryer.Default(retryProperties.getPeriod(),retryProperties.getMaxPeriod(),retryProperties.getMaxAttempts());
    }

    @Bean
    Logger customLog(){
        return new CustomLog();
    }

}
