package com.chajiu.service.Impl;
import com.chajiu.mapper.CategoryMapper;
import com.chajiu.pojo.Category;
import com.chajiu.pojo.Poetry;
import com.chajiu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        return categoryMapper.findAll();
    }

    @Override
    public Category findOne(Integer id) {
        return categoryMapper.findOne(id).toSimpleInstance();
    }

    @Override
    public void save(Category category) {
        categoryMapper.save(category);
    }

    @Override
    public void delete(Integer id) {
        categoryMapper.delete(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public List<Category> findPossibleCategory(String name) {
        return categoryMapper.findPossibleCategory(name);
    }


}
