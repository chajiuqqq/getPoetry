package com.chajiu.mapper;

import com.chajiu.pojo.PoetryAuthor;

import java.util.List;

public interface PoetryAuthorMapper {

    /**
     * 依据id找作者，包含诗词
     * @param id
     * @return
     */
    PoetryAuthor findOne(Integer id);

    /**
     * 查找所有author，不包含诗词
     * @return
     */
    List<PoetryAuthor> findAll();
}
