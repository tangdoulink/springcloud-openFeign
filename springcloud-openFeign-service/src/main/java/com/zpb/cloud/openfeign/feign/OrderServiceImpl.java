package com.zpb.cloud.openfeign.feign;

import com.zpb.cloud.openfeign.api.OrderOpenFeignClient;
import com.zpb.cloud.openfeign.util.Result;
import feign.Request;
import feign.RetryableException;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * @author       pengbo.zhao
 * @description  order-impl
 * @createDate   2022/1/12 11:00
 * @updateDate   2022/1/12 11:00
 * @version      1.0
 */

@RestController
public class OrderServiceImpl implements OrderOpenFeignClient {

    @Override
    public Result<String> getOrder(String orderId) throws IOException {

        boolean b1 = new Random().nextBoolean();
        System.err.println("接收到的参数是：" + orderId);

        if(b1){
            return Result.succ("open feign service response: "+ orderId + " - "+LocalDateTime.now());
        }

        // // 抛出异常
        Request.HttpMethod post = Request.HttpMethod.POST;
        String url = "http://springcloud-openFeign-service/client/order/get";
        HashMap<String, Collection<String>> headers = new HashMap<>(1);
        Request.Body body = Request.Body.create(orderId.getBytes());
        Request request = Request.create(post,url,headers,body,null);

        throw new RetryableException(500,"重试异常", post,new Date(),request);
        // throw new IOException("io-重试异常");
    }

}
