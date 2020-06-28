package com.example.mybatis.controller;

import com.example.mybatis.common.utils.ExcelUtils;
import com.example.mybatis.entity.POJO.UserExcel;
import com.example.mybatis.entity.POJO.excel.UserExcelModel;
import com.example.mybatis.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 南街北巷
 * @date 2020/6/29 0029 上午 0:42
 **/
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Api(value = "用户接口", tags = "用户接口")
@RestController
@RequestMapping("/user")
public class ExcelController {

    @Autowired
    private IUserService iUserService;

    @ApiOperation(value = "导入Excel表格", notes = "导入Excel表格")
    @RequestMapping(value = "/readExcel", method = RequestMethod.POST)
    public void readExcelModel() {
        try {

            FileInputStream inputStream = new FileInputStream("d:\\test\\test1.xlsx");
            List<UserExcelModel> list = ExcelUtils.readExcel(new BufferedInputStream(inputStream), UserExcelModel.class);

            List<UserExcel> userList = new ArrayList<>();
            list.forEach(demo -> {
                UserExcel user = new UserExcel(
                        demo.getUserName(),
                        demo.getPassword(),
                        demo.getRealName(),
                        demo.getPhone(),
                        demo.getEmail());
                userList.add(user);
            });
            System.out.println(list.size());
            //将表格数据保存到数据库
//            iUserService.saveOrUpdateBatch(userList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "导出Excel表格", notes = "导出Excel表格")
    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public ResponseEntity exprotExcel() {

        try {
            List<UserExcel> list = new ArrayList<>();
            List<UserExcelModel> dataList = new ArrayList<>();
            list.forEach(user -> {
                UserExcelModel userExcelModel = new UserExcelModel(
                        user.getUserName(),
                        user.getPassword(),
                        user.getRealName(),
                        user.getPhone(),
                        user.getEmail());
                dataList.add(userExcelModel);
            });
            System.out.println(dataList.size());

            //数据写入到字节流
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            boolean flag = ExcelUtils.writeExcel(bos, UserExcelModel.class, dataList);

            //下载文件
            String fileName = "下载整改建议.xls";
            log.info("开始下载导出的Excel文件");
            return ExcelUtils.downloadExcel(fileName, bos);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
