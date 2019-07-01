package com.example.demo.controller;

import java.util.List;
import com.example.demo.entity.User;
import com.example.demo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/CRUD", method = { RequestMethod.GET, RequestMethod.POST })
public class CRUD {

@Autowired
private Userservice userservice;

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = userservice.delete(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "/update",method =RequestMethod.POST )
    public String update(User user){
        int result=userservice.Update(user);
        if (result>=1)
        {
            return "更新成功";
        }else
            {
                return "更新失败";
            }

    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(User user) {
        return userservice.insertUser(user);
    }

    @RequestMapping("/ListUser")
    @ResponseBody
    public List<User> ListUser(){
        return userservice.ListUser();
    }

    @RequestMapping("/ListUserByname")
    @ResponseBody
    public List<User> ListUserByname(@RequestParam String name){
        return userservice.findByName(name);
    }
}


