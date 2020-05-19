package com.example.mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.example.mybatis.common.utils.Page;
import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        //获取系统时间
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        //转换为日期格式的字符串
        String now = sd.format(date);
        System.out.println(now);
        user.setCreatedTime(date);
        user.setUpdatedTime(date);
        userMapper.insertUser(user);
        return "用户表保存成功，用户为:" + user;
    }

    @DeleteMapping("/delete/all")
    public String delete() {
        userMapper.deleteAllUser();
        return "用户表删除成功!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userMapper.deleteUserById(id);
        return "用户Id为:" + id + "的删除成功!";
    }

    @PutMapping("/update/byId")
    public String update(@RequestBody User user) {
        User oldUser = userMapper.getById(user.getId());
        System.out.println("原用户信息是" + oldUser);
        user.setUpdatedTime(new Date());
        userMapper.updateUserById(user);
        User newUser = userMapper.getById(user.getId());
        System.out.println("当前用户信息是：" + newUser);
        return "用户表更新成功,新的用户信息为:" + newUser;
    }

    @PostMapping("/get/all")
    public String getAll() {
        //查询所有用户
        List<User> list = userMapper.getAllUser();
        System.out.println(list);
        return "用户信息查询成功，用户信息为：" + list;
    }

    @PostMapping("/get/byName")
    public String byName(@RequestParam("name") String name) {
        //根据姓名查询
        List<User> users = userMapper.getByName(name);
        System.out.println(users);
        return "用户信息查询成功,用户信息为:" + users;
    }

    @PostMapping("/get/byId")
    public String byId(@RequestBody User user) {
        //根据id查询
        User queryUser = userMapper.getById(user.getId());
        System.out.println(queryUser);
        return "用户信息查询成功,用户信息为:" + queryUser;
    }

    @PostMapping("/get/byPage")
    public String byPage(@RequestBody Page page) {
        //注意：这里PageHelper中的Page类是不允许重写的，只能重写自己的Page工具类
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<User> list = userMapper.getAllUser();
        System.out.println(list);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        return "分页查询成功" + pageInfo;
    }

}