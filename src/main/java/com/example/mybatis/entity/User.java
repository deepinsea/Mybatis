package com.example.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author 南街北巷
 * @data 2020/4/21 22:41
 */
@Data
public class User {
    private Integer id;
    private String name;
    private int age;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedTime;
}
