package com.zpb.cloud.openfeign.fallback;

import com.zpb.cloud.openfeign.model.User;
import com.zpb.cloud.openfeign.feign.UserOpenFeignClient;
import com.zpb.cloud.openfeign.util.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author       pengbo.zhao
 * @description  user-client-fallback
 * @createDate   2022/1/10 16:11
 * @updateDate   2022/1/10 16:11
 * @version      1.0
 */
@Component
public class UserClientFallback implements UserOpenFeignClient {

    @Override
    public Result<List<User>> getUser(Pageable pageable) {
        throw new RuntimeException("UserClientFallback-Page<User>#getUser");
    }

    @Override
    public User getUser(User user) {
        throw new RuntimeException("UserClientFallback-User#getUser");
    }

    @Override
    public List<User> getUsers() {
        throw new RuntimeException("UserClientFallback-List<User>#getUser");
    }

    // @Override
    // public User update(Long userId, User uer) {
    //     throw new RuntimeException("UserClientFallback-User#getUser");
    // }

    // @Override
    // public void delete(Long userId) {
    //     throw new RuntimeException("UserClientFallback-delete");
    // }

}
