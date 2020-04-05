package com.chajiu.mapper;

import com.chajiu.pojo.PoetryAuthor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PoetryAuthorMapper {

    /**
     * 依据id找作者，包含诗词
     * @param id
     * @return
     */
    PoetryAuthor findOne(Integer id);

    /**
     * 返回作者的信息，不包含所写诗词
     * @param id
     * @return
     */
    PoetryAuthor findSimpleOne(Integer id);

    /**
     * 查找诗词有分类记录的author，不包含诗词
     * @return
     */
    List<PoetryAuthor> findAll();

    List<PoetryAuthor> findLikeName(@Param("name") String name);
}
