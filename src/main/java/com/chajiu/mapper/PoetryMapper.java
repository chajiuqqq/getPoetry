package com.chajiu.mapper;

import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.PoetryAuthor;

import java.util.List;

public interface PoetryMapper {

    /**
     * 按照id或者title找诗，返回包含作者
     * @param
     * @return
     */
    Poetry findOne(Poetry poetry);

    List<Poetry> findByAuthorId(Integer id);


}
