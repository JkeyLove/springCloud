package org.example.service.client;

import org.example.entity.User;
import org.example.entity.UserBorrowDetail;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component   //注意，需要将其注册为Bean，Feign才能自动注入
public class UserFallbackClient implements UserClient{

    @Override
    public User findUserById(int uid) {
        User user = new User();
        user.setName("我是补救措施");
        user.setSex("男");
        return user;
    }
}
