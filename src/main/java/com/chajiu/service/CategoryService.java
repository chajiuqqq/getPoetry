package com.chajiu.service;

import com.chajiu.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findOne(Category category);

    void save(Category category);
    void delete(Integer id);
    void update(Category category);

}