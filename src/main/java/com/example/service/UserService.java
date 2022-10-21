package com.example.service;

import com.example.entity.User;


import java.util.List;


public interface UserService {

    public void addUser(User user);

    public List<User> getAllUsers();

    public void deleteUser(int id);

    public void updateUser(int id, User user);

    public User findUser(int id);
}
