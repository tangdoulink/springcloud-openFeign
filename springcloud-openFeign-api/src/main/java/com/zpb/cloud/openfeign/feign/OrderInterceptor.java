package com.zpb.cloud.openfeign.feign;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.SneakyThrows;

/**
 * @author       pengbo.zhao
 * @description  order-拦截器
 * @createDate   2022/1/13 17:41
 * @updateDate   2022/1/13 17:41
 * @version      1.0
 */
public class OrderInterceptor implements RequestInterceptor {

    @Override
    @SneakyThrows
    public void apply(RequestTemplate template) {

       //  String s = new String(template.body()).trim();
       //  System.err.println("原-请求参数是："+s);
       //
       //  ObjectMapper objectMapper = new ObjectMapper();
       //  JsonNode jsonNode = objectMapper.readTree(s);
       //  JsonNode orderId = jsonNode.get("orderId");
       //  System.err.println("现-请求参数是："+ orderId);
       //
       //  // 重新生成新的请求参数
       // template.body(orderId.asText());

    }
}
