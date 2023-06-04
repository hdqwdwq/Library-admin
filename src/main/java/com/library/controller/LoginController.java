package com.library.controller;

import com.library.domain.Admin;
import com.library.domain.Login;
import com.library.service.AdminService;
import com.library.until.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "登录管理 廖思宇")
public class LoginController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    @ApiOperation(value = "判断是否能登录 廖思宇")
    public JsonResult checkPassword(@RequestBody Login login) {
        String result = adminService.checkPassWord(login);
        System.out.println(result);
        if (result.equals("密码正确")) {
            return new JsonResult();
        } else {
            return new JsonResult(false, "登录失败");
        }
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册 廖思宇")
    public JsonResult Register(@RequestBody Admin admin) {
        if (admin.getPassword() != "" && admin.getUsername() != "") {
            adminService.add(admin);
            return new JsonResult();
        } else {
            return new JsonResult(false, "注册失败");
        }
    }
}
