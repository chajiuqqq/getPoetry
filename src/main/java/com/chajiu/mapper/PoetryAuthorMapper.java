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

    /**
     * 模糊查找作者，结果依据record降序排序
     * @param name
     * @return
     */
    List<PoetryAuthor> findLikeName(@Param("name") String name);

    /**
     * 更新作者信息
     * @param author
     */
    void update(PoetryAuthor author);

    /**
     * 读取每个作者在分类中拥有的诗词数
     * @return
     */
    List<PoetryAuthor> findRecordCount();


}
