package com.chajiu.mapper;

import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.PoetryAuthor;
import com.chajiu.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PoetryMapper {

    /**
     * 按照id找诗，返回包含作者 分类
     * @param
     * @return
     */
    Poetry findOne(Poetry poetry);
    Poetry findOne(@Param("id") Integer pid);

    List<Poetry> findByAuthorId(Integer id);

    List<Poetry> findLikeTitle(@Param("title") String title, @Param("page") Page page);

}
