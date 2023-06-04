package com.library.mapper;

import com.library.mapper.domain.Admin;
import com.library.mapper.domain.Login;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AdminMapper {
    List<Admin> selectAll();
    //根据id查询单条数据
    Admin selectByid(Long id);
    //编辑
    void update(Admin admin);
    Login selectByUsername(String username);
    List<Admin> selectByName(String username);

    void add(Admin admin);
}
