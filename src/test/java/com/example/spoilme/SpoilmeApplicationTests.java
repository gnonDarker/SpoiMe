package com.example.spoilme;

import com.example.spoilme.controller.LoginController;
import com.example.spoilme.netty.ChatMessage;
import com.example.spoilme.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;

@SpringBootTest
class SpoilmeApplicationTests {

    @Autowired
    LoginController loginController;

    @Test
    void contextLoads() {
        loginController.login(new User());
    }
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        ChatMessage chatMessage = new ChatMessage(1001,1,"张三",2,"发送消息",new Date());
        redisTemplate.boundValueOps("userKey").set(chatMessage);
        System.out.println(redisTemplate.hasKey("userKey"));
        ChatMessage rs = (ChatMessage) redisTemplate.boundValueOps("userKey").get();
        System.out.println("rs = " + rs);

        ChatMessage rs2 = (ChatMessage) redisTemplate.opsForValue().get("userKey");
        System.out.println("rs2 = " + rs2);
    }

}
