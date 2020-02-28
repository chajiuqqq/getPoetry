package com.chajiu.mapper;


import com.chajiu.pojo.Poetry;
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

    @Test
    public void findOne(){
        Poetry p=new Poetry();
        p.setTitle("秋日二首 一");
        System.out.println(poetryMapper.findOne(p));
    }

}
