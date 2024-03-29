package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

import java.util.List;

    @Service
    public class Userservice {
        @Autowired
        private UserMapper userMapper;//添加。。。。。。。。

        public List<User> findByName(String name) {
            return userMapper.findUserByName(name);
        }

        public User insertUser(User user) {
            userMapper.insertUser(user);
            return user;
        }
        public List<User> ListUser(){
            return	userMapper.ListUser();
        }

        public int Update(User user){
            return userMapper.Update(user);
        }

        public int delete(int id){
            return userMapper.delete(id);
        }
    }


