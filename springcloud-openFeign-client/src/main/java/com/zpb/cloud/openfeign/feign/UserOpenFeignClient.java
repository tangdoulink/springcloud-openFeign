package com.zpb.cloud.openfeign.feign;

import com.zpb.cloud.openfeign.fallback.UserClientFallback;
import com.zpb.cloud.openfeign.model.User;
import com.zpb.cloud.openfeign.util.Result;
import org.springframework.cloud.openfeign.CollectionFormat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author       pengbo.zhao
 * @description  openFeign-客户端
 * @createDate   2022/1/6 15:19
 * @updateDate   2022/1/6 15:19
 * @version      1.0
 */
@Component
@FeignClient(name= "springcloud-openFeign-service",path = "user",contextId = "user-feign-client",fallback = UserClientFallback.class)
public interface UserOpenFeignClient {

    /**
     * 分页查询
     * @param pageable pageable
     * @return pagedList
     */
    // @CollectionFormat(feign.CollectionFormat.CSV)
    @RequestMapping(method = RequestMethod.GET, value = "/page/list")
    Result<List<User>> getUser(Pageable pageable);

    /**
     * 获取用户
     * @param user user
     * @return user
     */
    @CollectionFormat(feign.CollectionFormat.CSV)
    @PostMapping(value = "/get")
    User getUser(@RequestBody User user);

    /**
     * 获取用户列表
     * @return userList
     */
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    List<User> getUsers();

    /**
     * 更新用户
     * @param userId id
     * @param uer user
     * @return user
     */
    // @RequestMapping(method = RequestMethod.POST, value = "/users/{userId}", consumes = "application/json")
    // User update(@PathVariable("userId") Long userId, User uer);

    /**
     * 删除用户
     * @param userId 用户id
     */
    // @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId:\\d+}")
    // void delete(@PathVariable Long userId);

}
