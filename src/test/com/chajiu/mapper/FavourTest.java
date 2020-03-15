package com.chajiu.mapper;


import com.chajiu.pojo.Favour;
import com.chajiu.service.FavourService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class FavourTest {

    @Autowired
    FavourService service;
    @Autowired
    FavourMapper mapper;

    @Test
    public void findAll(){
        System.out.println(service.findAllByUserId(3).size());
    }

    @Test
    public void save() throws Exception {
        Favour favour=new Favour();
        favour.setUserId(3);
        favour.setPoetryId(144);
        favour.setCreateDate(new Date());
        for(int i=0;i<20;i++)
            service.save(favour);
    }


    @Test
    public void exist(){
        Favour favour=new Favour();
        favour.setUserId(3);
        favour.setPoetryId(145);
        System.out.println(service.exist(favour));
    }

    @Test
    public void delete(){
        Favour favour=new Favour();
        favour.setUserId(2);
        favour.setPoetryId(123);
        service.delete(favour);
    }
}
