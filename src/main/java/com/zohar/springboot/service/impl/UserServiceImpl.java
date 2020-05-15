package com.zohar.springboot.service.impl;



import com.zohar.springboot.entity.User;
import com.zohar.springboot.repository.UserRepository;
import com.zohar.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
// 4、服务接口实现类
@Service
public class UserServiceImpl implements UserService {
    @Autowired //它可以对类成员变量、方法及构造函数进行标注，让 spring 完成 bean 自动装配的工作
    private UserRepository userRepository;
    private String name;

    @Override
    public List<User> getUserList(){
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id){
        return userRepository.findById(id);
    }

    @Override
    public User findUserByName(String Name){
        return (User) userRepository.findByName(name);
    }








}
