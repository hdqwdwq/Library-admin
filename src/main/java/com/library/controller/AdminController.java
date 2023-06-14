package com.library.controller;

import com.library.config.MD5Utils;
import com.library.domain.Admin;
import com.library.service.AdminService;
import com.library.until.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController//controller+responBody
@RequestMapping("/Personal")
@Api(tags = "个人管理 周巾岚")
public class AdminController {
    @Autowired
    private AdminService adminService;
    //查询所有
    //根据username查询
    @GetMapping("/{username}")
    @ApiOperation(value = "根据username查询 周巾岚")
    public List<Admin> queryByName(@PathVariable("username")String username){return adminService.selectByName(username);}
    //新增+修改
    @PutMapping
    @ApiOperation(value = "用户新增+修改 周巾岚")
    public JsonResult addOrupdata(@RequestBody Admin admin){
        try{
            admin.setPassword(MD5Utils.string2MD5(admin.getPassword()));
            adminService.update(admin);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"操作失败");
        }
    }
}
