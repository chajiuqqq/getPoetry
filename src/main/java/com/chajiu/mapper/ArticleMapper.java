package com.chajiu.mapper;

import com.chajiu.pojo.Article;
import com.chajiu.util.Page;

import java.util.List;

public interface ArticleMapper {

    void save(Article article);

    /**
     * 用文章id获取文章
     * @param id
     * @return
     */
    Article findOne(Integer id);

    List<Article> findByTitle(String title);

    List<Article> findAll();
    List<Article> findAll(Page page);

    Integer total();
}
