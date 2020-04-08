package com.chajiu.mapper;


import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.SharedImg;
import com.chajiu.service.PoetryService;
import com.chajiu.service.SharedImgService;
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
    @Autowired
    SharedImgService sharedImgService;

    @Test
    public void run() throws Exception {
        Poetry poetry=new Poetry();
        poetry.setId(194);
        Poetry one = service.findOne(poetry);
        String img = SharedImgUtil.makeImg(one, "http://poetry.chajiuqqq.cn", "E:\\project\\MyPoetry\\src\\main\\resource\\");
        System.out.println(img);
    }

    @Test
    public void save(){
        SharedImg img=new SharedImg(94,"12345.png");
        sharedImgService.save(img);
    }

    @Test
    public void find(){
        SharedImg img = sharedImgService.find(95);
        if(img==null)
            System.out.println("dd");
        else
            System.out.println("gg");
    }
    @Test
    public void del(){
        SharedImg img = sharedImgService.find(38083);
        if(img!=null)
            sharedImgService.delete(img);

    }



}
