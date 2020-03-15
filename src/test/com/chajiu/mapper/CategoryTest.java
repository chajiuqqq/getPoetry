package com.chajiu.mapper;


import com.chajiu.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CategoryTest {

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CategoryService service;

    @Test
    public void findAll(){
        System.out.println(categoryMapper.findAll());
    }


    @Test
    public void findOne(){
        System.out.println(service.findOne(118).getPoetries());
    }

    @Test
    public void findPossible(){
        System.out.println(service.findPossibleCategory("爱"));
    }

}
