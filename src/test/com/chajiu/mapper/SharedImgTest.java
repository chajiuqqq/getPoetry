package com.chajiu.mapper;


import com.chajiu.pojo.Poetry;
import com.chajiu.service.PoetryService;
import com.chajiu.util.SharedImgUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SharedImgTest {
    @Autowired
    PoetryService service;

    @Test
    public void run() throws Exception {
        Poetry poetry=new Poetry();
        poetry.setId(194);
        Poetry one = service.findOne(poetry);
        String img = SharedImgUtil.makeImg(one, "http://poetry.chajiuqqq.cn", "E:/project/MyPoetry/target/MyPoetry/WEB-INF/classes/");
        System.out.println(img);
    }

}
