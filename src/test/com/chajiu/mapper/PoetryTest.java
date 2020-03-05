package com.chajiu.mapper;


import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.PoetryAuthor;
import com.chajiu.service.PoetryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PoetryTest {
    @Autowired
    PoetryMapper poetryMapper;
    @Autowired
    PoetryService service;
    @Test
    public void findOne(){
        Poetry p=new Poetry();
        p.setId(2741);
        Poetry poetry=null;
        try {
            poetry = service.findOne(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(poetry);
        System.out.println("\t\t"+poetry.getPoetryAuthor());
        System.out.println("\t\t"+ poetry.getCategories());
    }

    @Test
    public void findByAuthorId(){
        System.out.println(poetryMapper.findByAuthorId(1));
    }

}
