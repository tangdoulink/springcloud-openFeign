package com.zpb.cloud.openfeign.controller;

import com.zpb.cloud.openfeign.api.OrderOpenFeignClient;
import com.zpb.cloud.openfeign.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author       pengbo.zhao
 * @description  order-controller
 * @createDate   2022/1/12 11:20
 * @updateDate   2022/1/12 11:20
 * @version      1.0
 */
@RestController
@RequestMapping("client/order/")
public class OrderController {

    @Resource
    private OrderOpenFeignClient orderOpenFeignClient;


    @GetMapping("get")
    public Result<String> getOrder(@RequestParam("orderId") String orderId) throws IOException {
        return orderOpenFeignClient.getOrder(orderId);
    }
}
