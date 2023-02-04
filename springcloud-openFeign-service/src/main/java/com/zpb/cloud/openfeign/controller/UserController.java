package com.zpb.cloud.openfeign.controller;

import com.zpb.cloud.openfeign.dao.UserDao;
import com.zpb.cloud.openfeign.model.User;
import com.zpb.cloud.openfeign.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author       pengbo.zhao
 * @description  user-controller
 * @createDate   2022/1/11 15:32
 * @updateDate   2022/1/11 15:32
 * @version      1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserDao userDao;

    @GetMapping("page/list")
    public Result<List<User>> getUser() {
        return Result.succ(userDao.userList);
    }

    @PostMapping("get")
    public User getUser(@RequestBody User user) {
        return userDao.userList.stream()
                .filter(u -> user.getName().equals(u.getName()))
                .collect(Collectors.toList())
                .get(0);
    }

}
