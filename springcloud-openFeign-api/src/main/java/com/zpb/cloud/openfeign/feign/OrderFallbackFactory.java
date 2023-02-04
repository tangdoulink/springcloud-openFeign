package com.zpb.cloud.openfeign.feign;

import com.zpb.cloud.openfeign.api.OrderOpenFeignClient;
import com.zpb.cloud.openfeign.util.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author       pengbo.zhao
 * @description  order-容错工厂
 * @createDate   2022/1/13 17:14
 * @updateDate   2022/1/13 17:14
 * @version      1.0
 */
@Component
public class OrderFallbackFactory implements FallbackFactory<OrderOpenFeignClient> {

    @Override
    public OrderOpenFeignClient create(Throwable cause) {
        return new OrderOpenFeignClient() {
            @Override
            public Result<String> getOrder(String orderId) {
                System.err.println("order-client 失败的原因是: "+cause.getMessage());
                return Result.fail("我是容错的处理工厂-返回的信息！！@");
            }
        };
    }
}
