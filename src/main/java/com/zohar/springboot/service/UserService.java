package com.zohar.springboot.service;

import com.zohar.springboot.entity.User;

import java.util.List;

// 3、服务接口
public interface UserService {
    public List<User> getUserList();
    public User findUserById(long id);

    public User findUserByName(String name);




}
