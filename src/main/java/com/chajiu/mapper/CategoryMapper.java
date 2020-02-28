package com.chajiu.mapper;

import com.chajiu.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> findAll();
    Category findOne(Category category);

    void save(Category category);
    void delete(Integer id);
    void update(Category category);

}
