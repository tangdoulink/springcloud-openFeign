package com.zpb.cloud.openfeign.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author       pengbo.zhao
 * @description  
 * @createDate   2022/1/13 19:32
 * @updateDate   2022/1/13 19:32
 * @version      1.0
 */
@Data
@Component
@RefreshScope
@ConfigurationProperties(prefix = "feign.custom.retry")
public class FeignRetryProperties {

    /**
     * 重试间隔
     */
    private Long period;

    /**
     * 最大重试间隔
     */
    private Long maxPeriod;

    /**
     * 最大重度次数
     */
    private Integer maxAttempts;

}
