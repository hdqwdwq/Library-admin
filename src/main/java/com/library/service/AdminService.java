package com.library.service;

import com.library.mapper.domain.Admin;
import com.library.mapper.domain.Login;

import java.util.List;

public interface AdminService {
    String checkPassWord(Login login);

    List<Admin> selectAll();
    //根据username查询单条数据
    Admin selectById(Long id);

    void update(Admin admin);

    void add(Admin admin);

    List<Admin> selectByName(String username);
}
