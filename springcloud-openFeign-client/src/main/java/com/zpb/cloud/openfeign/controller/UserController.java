package com.zpb.cloud.openfeign.controller;

import com.zpb.cloud.openfeign.model.User;
import com.zpb.cloud.openfeign.feign.UserOpenFeignClient;
import com.zpb.cloud.openfeign.util.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author       pengbo.zhao
 * @description  user-controller
 * @createDate   2022/1/11 15:49
 * @updateDate   2022/1/11 15:49
 * @version      1.0
 */
@RestController
@RequestMapping("client/user")
public class UserController {

    @Resource
    private UserOpenFeignClient userOpenFeignClient;

    // @GetMapping("page/list")
    // public Result<User> getUserList(@NotNull(message = "size不能为空") Integer size) {
    //     return userOpenFeignClient.getUser(PageRequest.of(1,10,Sort.by("name")));
    // }

    @GetMapping("page/list")
    public Result<List<User>> getUserList(@PageableDefault(page=2,size=17,sort="name,asc") Pageable pageable) {
        return userOpenFeignClient.getUser(pageable);
    }

    @PostMapping("get")
    public User getUser(@RequestBody User user) {
        return userOpenFeignClient.getUser(user);
    }

}
