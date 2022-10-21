package com.example.dao;

import com.example.entity.User;

import java.util.List;

public interface UserDao {

    public void addUser(User user);

    public List<User> getAllUsers();

    public void deleteUser(int id);

    public void updateUser(int id, User user);

    public User findUser(int id);


}
