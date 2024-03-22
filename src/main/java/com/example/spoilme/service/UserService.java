package com.example.spoilme.service;

import com.example.spoilme.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User checkExist(User user);

    User login(User user);

    void register(User user);

    public void deleteUser(int id);
}
