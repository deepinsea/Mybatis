package com.example.mybatis.entity.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author 南街北巷
 * @date 2020/6/29 0029 上午 0:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserExcel {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "用户名不能为空")
    @NotBlank(message = "用户名不能为字符串")
    private String userName;

    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空字符串")
    private String password;

    private String realName;

    @NotNull(message = "手机号码不能为空")
    @NotBlank(message = "手机号码不能为空字符串")
    @Length(max = 11, min = 11, message = "手机号只能为{max}位")
    @Pattern(regexp ="^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String phone;

    @NotNull(message = "邮箱地址不能为空")
    @NotBlank(message = "邮箱地址不能为空字符串")
    @Pattern(regexp ="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", message = "邮箱地址格式有误")
    private String email;

}
