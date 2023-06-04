package com.library.service.impl;

import com.library.mapper.domain.Category;
import com.library.mapper.CategoryMapper;
import com.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> selectAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public Category selectById(long id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public void deleteById(long id) {
        categoryMapper.deleteById(id);
    }
}
