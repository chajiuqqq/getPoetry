package com.chajiu.mapper;


import com.chajiu.pojo.Poetry;
import com.chajiu.service.PoetryService;
import com.chajiu.util.Page;
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

        System.out.println(poetryMapper.findOne(p));
        System.out.println(poetryMapper.findOne(2741));

    }

    @Test
    public void findByAuthorId(){
        System.out.println(poetryMapper.findByAuthorId(1));
    }



    @Test
    public void likeTitle(){
        Page page=new Page();
        page.setStart(0);
        page.setCount(5);

        System.out.println(service.findLikeTitle("咏").size());
        System.out.println(service.findLikeTitle("咏",page).size());

    }
}
