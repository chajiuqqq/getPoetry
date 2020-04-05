package com.chajiu.mapper;


import com.chajiu.pojo.PoetryAuthor;
import com.chajiu.pojo.SearchResult;
import com.chajiu.service.PoetryAuthorService;
import com.chajiu.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SearchTest {

    @Autowired
    SearchService searchService;

    @Test
    public void searchTest(){
        SearchResult search = searchService.search("爱");
        System.out.println(search);
    }
}
