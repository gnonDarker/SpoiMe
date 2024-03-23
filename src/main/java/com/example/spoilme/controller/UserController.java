package com.example.spoilme.controller;

import com.example.spoilme.pojo.Result;
import com.example.spoilme.pojo.User;
import com.example.spoilme.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){

        log.info("登录: {}", user);
        User u = userService.checkExist(user);
        //用户名存在
        if(u != null){
            u = userService.login(user);//执行登录操作
            if(u != null) return Result.success(u);
            else return Result.error("用户名或密码错误");
        }
        //用户名不存在
        else{
            return Result.success("用户不存在");
        }
    }
    @PutMapping("/register")
    public Result register(@RequestBody User user){
        userService.register(user);//执行注册操作
        return Result.success("注册成功");
    }
    @GetMapping("/user/list")
    public Result getUserList(){
        List<User> list = userService.getUsers();
        return Result.success(list);
    }
    @DeleteMapping("/user/delete")
    public Result deleteUser(@RequestBody User user){
        userService.deleteUser(user.getUId());
        return Result.success("删除成功");
    }
    @PostMapping("/user/modify")
    public Result modifyUserInfo(@RequestBody User user){
        userService.modifyUser(user);
        return Result.success("修改成功");
    }
}
