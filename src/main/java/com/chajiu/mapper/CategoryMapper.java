package com.chajiu.mapper;

import com.chajiu.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    /**
     * 查找所有分类 不包含诗词
     * @return
     */
    List<Category> findAll();

    /**
     * 依据id找分类，包含诗词
     * @param id
     * @return
     */
    Category findOne(Integer id);

    /**
     * 模糊查询分类，不包含诗词
     * @param name
     * @return
     */
    List<Category> findPossibleCategory(String name);


    void save(Category category);
    void delete(Integer id);
    void update(Category category);

}
