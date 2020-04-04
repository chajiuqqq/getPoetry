package com.chajiu.mapper;


import com.chajiu.pojo.Favour;
import com.chajiu.service.FavourService;
import com.chajiu.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class FavourTest {

    @Autowired
    FavourService service;
    @Autowired
    FavourMapper mapper;

    @Test
    public void findAll(){
        System.out.println(service.findAllByUserId(3));
    }
    @Test
    public void findAllByPage(){
        Page page=new Page();
        page.setStart(18);
        page.setCount(5);
        System.out.println(service.findAllByUserId(4,page));
    }

    @Test
    public void save() throws Exception {
        Random random=new Random();
        Favour favour=new Favour();
        favour.setUserId(4);
        favour.setCreateDate(new Date());
        for(int i=0;i<20;i++) {
            favour.setPoetryId(random.nextInt(5000));
            service.save(favour);
        }
    }


    @Test
    public void exist(){
        Favour favour=new Favour();
        favour.setUserId(4);
        favour.setPoetryId(144);
        System.out.println(service.exist(favour));
    }

    @Test
    public void delete() throws Exception {
        Favour favour=new Favour();
        favour.setUserId(4);
        favour.setPoetryId(144);
        service.delete(favour);
    }
}
