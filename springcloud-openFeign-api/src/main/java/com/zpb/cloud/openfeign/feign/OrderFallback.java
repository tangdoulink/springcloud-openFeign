package com.zpb.cloud.openfeign.feign;

import com.zpb.cloud.openfeign.api.OrderOpenFeignClient;
import com.zpb.cloud.openfeign.util.Result;
import org.springframework.stereotype.Component;

/**
 * @author       pengbo.zhao
 * @description  order-client-fallback
 * @createDate   2022/1/13 15:28
 * @updateDate   2022/1/13 15:28
 * @version      1.0
 * <P>
 *     定义容错的处理类，也就是回退逻辑，无法知道熔断的异常信息。
 * </P>
 */
@Component
public class OrderFallback implements OrderOpenFeignClient {

    @Override
    public Result<String> getOrder(String orderId) {
        return Result.fail("我是容错的处理类-返回的信息");
    }
}
