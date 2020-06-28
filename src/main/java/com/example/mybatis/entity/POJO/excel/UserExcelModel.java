package com.example.mybatis.entity.POJO.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author 南街北巷
 * @date 2020/6/29 0029 上午 0:32
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserExcelModel extends BaseRowModel {

    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "用户名", index = 0)
    private String userName;

    @ExcelProperty(value = "密码", index = 1)
    private String password;

    @ExcelProperty(value = "真实姓名", index = 2)
    private String realName;

    @ExcelProperty(value = "电话号码", index = 3)
    private String phone;

    @ExcelProperty(value = "邮箱地址", index = 4)
    private String email;

    private String roleType;

    private Integer departmentId;

    private String remark;

    public UserExcelModel(String userName, String password, String realName, String phone, String email) {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
