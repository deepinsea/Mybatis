package com.example.mybatis.controller;

import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 南街北巷
 * @data 2020/4/21 23:35
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/get/all")
    public String getAll(){
        List<User> list=userMapper.getAllUser();
        System.out.println(list);
        return "用户信息查询成功，用户信息为："+list;
    }

    @PostMapping("/get/byName")
    public String query(@RequestParam("name") String name){
        List<User> users= userMapper.getByName(name);
        System.out.println(users);
        return "用户信息查询成功,用户信息为:"+users;
    }

    @PostMapping("/add")
    public String add(@RequestBody User user){
        //获取系统时间
        Date date= new Date();
        SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
        //转换为日期格式的字符串
        String now = sd.format(date);
        System.out.println(now);
        user.setCreatedTime(date);
        user.setUpdatedTime(date);
        userMapper.insertUser(user);
        return "用户表保存成功，用户为:"+user;
    }
    @DeleteMapping("/delete/all")
    public String delete() {
        userMapper.deleteAllUser();
        return "用户表删除成功!";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        userMapper.deleteUserById(id);
        return "用户Id为:"+id+"的删除成功!";
    }

    @PutMapping("/update/byId")
    public String update(@RequestBody User user){
        user.setUpdatedTime(new Date());
        userMapper.updateUserById(user);
        System.out.println(user);
        return "用户表更新成功,新的用户信息为:"+user;
    }

}