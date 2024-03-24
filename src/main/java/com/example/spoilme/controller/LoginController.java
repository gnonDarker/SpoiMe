package com.example.spoilme.controller;

import com.example.spoilme.pojo.Result;
import com.example.spoilme.pojo.User;
import com.example.spoilme.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("员工登录: {}", user);
        User u = userService.checkExist(user);
        //用户名存在
        if(u != null){
            u = userService.login(user);//执行登录操作
            if(u != null) return Result.success(u);
            else return Result.error("用户名或密码错误");
        }
        //用户名不存在
        else{
            userService.register(user);//执行注册操作
            u = userService.login(user);
            return Result.success("注册成功");
        }
    }
}
