package com.chajiu.mapper;


import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.PoetryCategory;
import com.chajiu.util.DataUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PoetryCategoryTest {
    @Autowired
    PoetryCategoryMapper poetryCategoryMapper;

    @Autowired
    PoetryMapper poetryMapper;


    @Test
    public void save(){
        PoetryCategory pc=new PoetryCategory();
        pc.setPid(1);
        pc.setCid(117);
        poetryCategoryMapper.save(pc);
    }


    @Test
    public void add(){
        Map<String, Integer> map = new DataUtil().toMapper();
        Map<String, Integer> notFoundMap=new HashMap<>();

        int i=0;
        int total=map.size();

        int success=0;

        for(Map.Entry<String ,Integer> item:map.entrySet()){
            i++;
            String title=item.getKey();
            Poetry poetry=new Poetry();
            poetry.setTitle(title);

            Poetry foundOne=null;
            try {
                 foundOne = poetryMapper.findOne(poetry);
            }catch (Exception e){
                notFoundMap.put(item.getKey(),item.getValue());
                System.out.println("多首诗歌：\t"+item.getKey());
            }
            if(foundOne!=null){
                PoetryCategory pc=new PoetryCategory();
                pc.setPid(foundOne.getId());
                pc.setCid(item.getValue());
                poetryCategoryMapper.save(pc);
                System.out.println("已保存\t======" + item.getKey());
                success++;
            }else{
                notFoundMap.put(item.getKey(),item.getValue());
            }

            System.out.println("成功："+success+"\t("+i+"/"+total+")");
        }

        System.out.println("=====");
        System.out.println("失败： "+notFoundMap.size());


    }

    @Test
    public void findPoetriesByCategory(){
        System.out.println(poetryCategoryMapper.findPoetriesByCategory(118));
    }



}
