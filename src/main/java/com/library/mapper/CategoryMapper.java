package com.library.mapper;

import com.library.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> selectAll();

        //根据id查询
    Category selectById(long id);
    //新增
    void add(Category category);
    void update(Category category);
    void deleteById(long id);
}
