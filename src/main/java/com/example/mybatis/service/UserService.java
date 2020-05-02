package com.example.mybatis.service;

import com.example.mybatis.entity.User;

/**
 * @author 南街北巷
 * @data 2020/4/21 22:55
 */
public interface UserService {
    /**
     * 新增用户
     * @param user
     */
    void insert(User user);
}
