package com.example.spoilme;

import com.example.spoilme.controller.UserController;
import com.example.spoilme.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest

public class UserTest {
    @Autowired
    UserController loginController;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Test
    void register() {
        User user = new User();
        loginController.register(user);
    }
}
