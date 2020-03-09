package com.chajiu.service;

import com.chajiu.pojo.Article;
import com.chajiu.util.Page;

import java.util.List;

public interface ArticleService {
    void save(Article article);

    Article findOne(Integer id);

    List<Article> findByTitle(String title);

    List<Article> findAll();
    List<Article> findAll(Page page);

    Integer total();
}
