package com.example.mybatis.controller;

import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 南街北巷
 * @data 2020/4/21 23:35
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/getUserInfo/all")
    public String query(){
        User user=new User();
        String now = String.valueOf(user.getCreatedTime());
        System.out.println(now);
        System.out.println(userMapper.getAllUser());
        return "用户信息查询成功,用户信息为:"+userMapper.getAllUser();
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
        userMapper.insertUser(user);
        System.out.println(user.getName());
        return "用户表保存成功，用户为:"+String.valueOf(user);
    }
    @DeleteMapping("/delete/all")
    public String delete() {
        userMapper.deleteAllUser();
        return "用户表删除成功!";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        userMapper.deleteUserById(id);
        return "用户Id为:"+id+"的删除成功!";
    }

}