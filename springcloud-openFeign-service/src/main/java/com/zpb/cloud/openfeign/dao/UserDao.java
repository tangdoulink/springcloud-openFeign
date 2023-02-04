package com.zpb.cloud.openfeign.dao;

import com.zpb.cloud.openfeign.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author       pengbo.zhao
 * @description  dao
 * @createDate   2022/1/11 15:41
 * @updateDate   2022/1/11 15:41
 * @version      1.0
 */
@Component
public class UserDao {

    public List<User> userList = new ArrayList<>();

    @PostConstruct
    public void initData(){
        userList.add(new User(1L,"张三",23));
        userList.add(new User(2L,"李四",24));
        userList.add(new User(3L,"王五",25));
    }

}
