package com.example.mybatis.mapper;

import com.example.mybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 南街北巷
 * @data 2020/4/21 22:42
 */
@Repository
@Mapper
public interface UserMapper {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from mybatis")
    List<User> getAllUser();

    /**
     * 根据名字查询
     * @param name
     * @return
     */
    @Select("select * from mybatis where name=#{name}")
    List<User> getByName(String name);
    /**
     * 新增用户
     * @param user
     * @return
     */
    @Insert("insert into mybatis(name,age,created_time,updated_time) values(#{name},#{age},#{createdTime},#{updatedTime})")
    void insertUser(User user);
    /**
     * 删除所有用户
     * 并重置自增Id为1
     */
    @Delete("truncate table mybatis")
    void deleteAllUser();
    /**
     * 根据ID删除用户
     * @param id
     */
    @Delete("delete from mybatis where id=#{id}")
    void deleteUserById(int id);

    /**
     * 更新用户
     * @param user
     */
    @Update("update mybatis set name=#{name},age=#{age},updated_time=#{updatedTime} where id=#{id}")
    void updateUserById(User user);
}
