package com.chajiu.mapper;


import com.chajiu.pojo.Category;
import com.chajiu.pojo.User;
import com.chajiu.service.CategoryService;
import com.chajiu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {

    @Autowired
    UserService service;

    @Test
    public void findAll(){
        System.out.println(service.findAll());
    }


    @Test
    public void findOne(){
        User user=new User();
        user.setName("zyy");
        System.out.println(service.findOne(user));
    }

    @Test
    public void save(){
        User user=new User();
        user.setName("zyy");
        user.setUsername("usernamezyy");
        user.setPassword("pwdzyy");
        user.setEmail("zyy@gmail.com");

        service.save(user);
    }

    @Test
    public void update(){
        User user=service.findOne(new User().id(1));
        user.setName("zyy2");
        service.update(user);
        System.out.println(service.findOne(new User().id(1)));
    }
    @Test
    public void delete(){
        service.delete(1);
    }
}
