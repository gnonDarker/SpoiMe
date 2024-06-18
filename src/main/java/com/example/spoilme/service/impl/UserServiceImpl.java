package com.example.spoilme.service.impl;

import com.example.spoilme.mapper.UserMapper;
import com.example.spoilme.pojo.User;
import com.example.spoilme.service.UserService;
import com.example.spoilme.utils.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers(User user) {
        return userMapper.getUsers(user);
    }

    @Override
    public User getUser(Integer id) {
        return userMapper.getUser(id);
    }

    @Override
    public User login(User user) {
        user.setPassword(Md5Utils.getMD5String(user.getPassword()));
        return userMapper.getByUsernameAndPassword(user);
    }

    @Override
    public void register(User user) {
        user.setPassword(Md5Utils.getMD5String(user.getPassword()));
        userMapper.addByUsernameAndPassword(user);
    }
    @Override
    public User checkExist(User user) {
        return userMapper.getByUsername(user);
    }

    @Override
    public void deleteUser(User user) {
        //调用数据库删除用户
        if(user.getId() == null)
            userMapper.deleteUserByName(user.getNickname());
        else
            userMapper.deleteUserById(user.getId());
    }

    @Override
    public void modifyUser(User user) {
        log.info("修改用户信息Service层"+user);
        userMapper.modifyUser(user);
    }
}
