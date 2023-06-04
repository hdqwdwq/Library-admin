package com.library.service;

import com.library.mapper.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> selectAll();
    //根据id查询
    Category selectById(long id);
    //新增
    void add(Category category);
    void update(Category category);
    void deleteById(long id);
}
