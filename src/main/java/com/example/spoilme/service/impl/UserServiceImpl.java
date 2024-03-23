package com.example.spoilme.service.impl;

import com.example.spoilme.mapper.UserMapper;
import com.example.spoilme.pojo.User;
import com.example.spoilme.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public User login(User user) {
        return userMapper.getByUsernameAndPassword(user);
    }

    @Override
    public void register(User user) {
        userMapper.addByUsernameAndPassword(user);
    }
    @Override
    public User checkExist(User user) {
        return userMapper.getByUsername(user);
    }

    @Override
    public void deleteUser(int id) {
        //调用数据库删除用户
        userMapper.deleteUserById(id);
    }

    @Override
    public void modifyUser(User user) {
        userMapper.modifyUser(user);
    }
}
