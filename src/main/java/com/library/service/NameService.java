package com.library.service;

import com.library.domain.Name;

import java.util.List;

public interface NameService {
    List<Name> selectAll();
    //根据id查询单条数据
    Name selectById(long id);
    //新增
    void add(Name name);
    void update(Name name);

    void deleteById(long id);

    void batchDelete(List<Long> ids);
}
