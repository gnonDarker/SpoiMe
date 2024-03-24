package com.example.spoilme.controller;

import com.example.spoilme.pojo.Result;
import com.example.spoilme.pojo.User;
import com.example.spoilme.service.UserService;
import com.example.spoilme.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
            if(u != null) return Result.success(JwtUtils.generateJwt("用户名",u.getName()));
            else return Result.error("用户名或密码错误");
        }
        //用户名不存在
        else{
            return Result.error("用户不存在");
        }
    }
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        log.info("用户注册："+user);
        userService.register(user);//执行注册操作
        return Result.success(JwtUtils.generateJwt("用户名",user.getName()));
    }
    @GetMapping("/user/list")
    public Result getUserList(){
        List<User> list = userService.getUsers();
        return Result.success(list);
    }
    @PostMapping("/user/delete")
    public Result deleteUser(@RequestBody User user){
        userService.deleteUser(user.getId());
        return Result.success("删除成功");
    }
    @PostMapping("/user/modify")
    public Result modifyUserInfo(@RequestBody User user){
        userService.modifyUser(user);
        return Result.success("修改成功");
    }
}
