package com.zpb.cloud.openfeign.config;

import feign.Response;
import feign.RetryableException;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author       pengbo.zhao
 * @description  feign-服务端-异常
 * @createDate   2022/9/21 10:46
 * @updateDate   2022/9/21 10:46
 * @version      1.0
 */
@Configuration
public class ClientErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        try {
            String message = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
            System.err.println("client error decoder message = " + message);
            return new RetryableException(response.status(), message,response.request().httpMethod(),new Date(),response.request());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO 可以返回自定义异常,也可以返回原始异常信息
        return defaultErrorDecoder.decode(methodKey,response);
    }

}
