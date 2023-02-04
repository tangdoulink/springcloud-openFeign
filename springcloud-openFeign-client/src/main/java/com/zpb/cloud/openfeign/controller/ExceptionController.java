package com.zpb.cloud.openfeign.controller;

import com.zpb.cloud.openfeign.api.ExceptionOpenFeignClient;
import com.zpb.cloud.openfeign.model.User;
import com.zpb.cloud.openfeign.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author       pengbo.zhao
 * @description  异常-controller
 * @createDate   2022/9/16 15:45
 * @updateDate   2022/9/16 15:45
 * @version      1.0
 */
@RestController
@RequestMapping("e")
public class ExceptionController {

    @Resource
    private ExceptionOpenFeignClient exceptionOpenFeignClient;

    @GetMapping("get")
    public Result<User> e(){
        Result<User> result = exceptionOpenFeignClient.getException();
        System.out.println("user = " + result.getData());
        return result;
    }

    @GetMapping("map")
    public Map<String,User> map(){
        return exceptionOpenFeignClient.map();
    }

}

