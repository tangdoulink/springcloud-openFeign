package com.zpb.cloud.openfeign.api;

import com.zpb.cloud.openfeign.model.User;
import com.zpb.cloud.openfeign.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author       pengbo.zhao
 * @description  
 * @createDate   2022/9/16 15:52
 * @updateDate   2022/9/16 15:52
 * @version      1.0
 */
@FeignClient(name = "springcloud-openFeign-service",contextId = "error-feign-client")
public interface ExceptionOpenFeignClient {

    /**
     * OpenFeign 异常测试
     * @return {@link Result}
     */
    @GetMapping("e/get")
    Result<User> getException();

    /**
     * map-序列化测试
     * @return map
     */
    @GetMapping("e/map")
    Map<String,User> map();

}
