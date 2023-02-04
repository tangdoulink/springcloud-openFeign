package com.zpb.cloud.openfeign.controller;

import com.zpb.cloud.openfeign.model.User;
import com.zpb.cloud.openfeign.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author       pengbo.zhao
 * @description  远程调用异常-controller
 * @createDate   2022/9/16 15:43
 * @updateDate   2022/9/16 15:43
 * @version      1.0
 */
@RestController
@RequestMapping("e")
public class ServiceExceptionController {

    @GetMapping("get")
    public Result<User> getUser() {
        boolean nextBoolean = new Random().nextBoolean();
        System.out.println("nextBoolean = " + nextBoolean);
        if(nextBoolean){
            return Result.succ(new User(1L,"zhangsan",23));
        }
        // throw new OpenFeignClientException(500,"测试异常");
        throw new RuntimeException("异常");
    }

    @GetMapping("map")
    public Map<String,User> map(){
        boolean nextBoolean = new Random().nextBoolean();
        System.out.println("nextBoolean = " + nextBoolean);
        HashMap<String, User> hashMap = new HashMap<>(1);
        hashMap.put("1",new User(2L,"李四",24));
        return hashMap;
    }

}
