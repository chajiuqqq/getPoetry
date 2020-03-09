package com.chajiu.mapper;


import com.chajiu.pojo.Article;
import com.chajiu.service.ArticleService;
import com.chajiu.service.CategoryService;
import com.chajiu.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ArticleTest {
    @Autowired
    ArticleService service;

    @Test
    public void findAll(){
        System.out.println(service.findAll());
        Page page=new Page();
        page.setStart(1);
        page.setCount(2);
        System.out.println(service.findAll(page));
    }



    @Test
    public void save(){
        Article article=new Article();
        article.setTitle("这是中文222");
        article.setAuthorName("zyy");
        article.setAuthorId(1);
        article.setPath("/sd/sd/dd.json");
        article.setCreateDate(new Date());
        service.save(article);
        System.out.println(article);
    }
    @Test
    public void findOne(){
        System.out.println(service.findOne(1));
    }
    @Test
    public void total(){
        System.out.println(service.total());
    }

    @Test
    public void findByTitle(){
        System.out.println(service.findByTitle("中文"));
    }


}
