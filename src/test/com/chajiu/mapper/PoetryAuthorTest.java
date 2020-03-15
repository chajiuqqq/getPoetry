package com.chajiu.mapper;


import com.chajiu.service.PoetryAuthorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PoetryAuthorTest {

    @Autowired
    PoetryAuthorService service;


    @Test
    public void findOne(){
        System.out.println(service.findOne(13));
    }

}
