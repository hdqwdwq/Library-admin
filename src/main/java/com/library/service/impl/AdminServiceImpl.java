package com.library.service.impl;

import com.library.config.MD5Utils;
import com.library.mapper.domain.Admin;
import com.library.mapper.domain.Login;
import com.library.mapper.AdminMapper;
import com.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public String checkPassWord(Login login) {
        Login admin = adminMapper.selectByUsername(login.getUsername());
        System.out.println(admin.getUsername());
        System.out.println(MD5Utils.string2MD5(login.getPassword()));
        //判断用户名是否为空
        if (admin == null) {
            return "账号不存在";
        }
        //判断密码是否正确
        if(admin.getPassword().equals(MD5Utils.string2MD5(login.getPassword()))){
            return "密码正确";
        }
        return "非法请求";
    }

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public Admin selectById(Long id) {
        return adminMapper.selectByid(id);
    }

    @Override
    public void update(Admin admin) {
        adminMapper.update(admin);
    }

    @Override
    public void add(Admin admin) {
        admin.setPassword(MD5Utils.string2MD5(admin.getPassword()));
        adminMapper.add(admin);
    }

    @Override
    public List<Admin> selectByName(String username) {
        return adminMapper.selectByName(username);
    }
}
