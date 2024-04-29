package com.example.spoilme.controller;

import com.example.spoilme.pojo.Result;
import com.example.spoilme.pojo.User;
import com.example.spoilme.service.UserService;
import com.example.spoilme.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("登录: {}", user);
        if(user.getName() != null)user.setNickname(user.getName());
        user.setName(null);
        log.info("登录: {}", user);

        User u = userService.checkExist(user);
        if(u != null){
            u = userService.login(user);//执行登录操作
            if(u != null) {
                Map<String, Object> claims = new HashMap<>();
                claims.put("userId", u.getId());
                claims.put("nickname", u.getNickname());
                return Result.success("登录成功",JwtUtils.generateJwt(claims));
            }
            else return Result.error("用户名或密码错误");
        }
        else{
            return Result.error("用户不存在");
        }
    }
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        if(user.getName() != null) user.setNickname(user.getName());
        user.setName(null);
        log.info("用户注册："+user);
        User u = userService.checkExist(user);
        if(u == null){
            userService.register(user);//执行注册操作
            Map<String, Object> claims = new HashMap<>();
            claims.put("userId", user.getId());
            claims.put("nickname", user.getNickname());
            return Result.success("登录成功",JwtUtils.generateJwt("用户名",JwtUtils.generateJwt(claims)));
        }
        else{
            return Result.error("用户已存在");
        }
    }
    @PostMapping("/user/list")
    public Result getUserList(@RequestBody(required = false) Integer id,
                              @RequestBody(required = false) String nickname){
        List<User> list = userService.getUsers(id,nickname);
        return Result.success(list);
    }
    @PostMapping("/user/delete")
    public Result deleteUser(@RequestBody User user){
        userService.deleteUser(user);
        return Result.success("删除成功");
    }
    @PostMapping("/user/modify")
    public Result modifyUserInfo(@RequestBody User user,@RequestHeader String token){
        user.setId(JwtUtils.getTokenId(token));
        log.info("修改用户信息："+user);
        userService.modifyUser(user);
        return Result.success("修改成功");
    }
}
