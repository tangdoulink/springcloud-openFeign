package com.zpb.cloud.openfeign.api;

import com.zpb.cloud.openfeign.config.OrderFeignClientConfig;
import com.zpb.cloud.openfeign.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

/**
 * @author       pengbo.zhao
 * @description  order-openfeign-client
 * @createDate   2022/1/12 10:54
 * @updateDate   2022/1/12 10:54
 * @version      1.0
 */
@Component
@FeignClient(
        name = "springcloud-openFeign-service",
        contextId = "order-feign-client",
        // fallback = OrderFallback.class,
        // fallbackFactory = OrderFallbackFactory.class,
        configuration = OrderFeignClientConfig.class
)
public interface OrderOpenFeignClient {

    /**
     * 查询订单
     * @param orderId orderId
     * @return String
     * @throws IOException io
     */
    @PostMapping("client/order/get")
    Result<String> getOrder(@RequestBody String orderId) throws IOException;

}
