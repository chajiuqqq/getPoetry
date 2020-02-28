package com.chajiu.mapper;


import com.chajiu.pojo.PoetryCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PoetryCategoryTest {
    @Autowired
    PoetryCategoryMapper poetryCategoryMapper;

    @Test
    public void save(){
        PoetryCategory pc=new PoetryCategory();
        pc.setPid(1);
        pc.setCid(117);
        poetryCategoryMapper.save(pc);
    }

}
