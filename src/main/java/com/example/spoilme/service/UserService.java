package com.example.spoilme.service;

import com.example.spoilme.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getUsers(Integer id,String nickname);
    User checkExist(User user);

    User login(User user);

    void register(User user);

    void deleteUser(User user);

    void modifyUser(User user);
}
