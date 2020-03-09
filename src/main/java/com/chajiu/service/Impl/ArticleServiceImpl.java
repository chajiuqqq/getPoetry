package com.chajiu.service.Impl;

import com.chajiu.mapper.ArticleMapper;
import com.chajiu.pojo.Article;
import com.chajiu.service.ArticleService;
import com.chajiu.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper mapper;

    @Override
    public void save(Article article) {
        mapper.save(article);
    }

    @Override
    public Article findOne(Integer id) {
        return mapper.findOne(id);
    }

    @Override
    public List<Article> findByTitle(String title) {
        return mapper.findByTitle(title);
    }

    @Override
    public List<Article> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<Article> findAll(Page page) {
        return mapper.findAll(page);
    }

    @Override
    public Integer total() {
        return mapper.total();
    }
}
