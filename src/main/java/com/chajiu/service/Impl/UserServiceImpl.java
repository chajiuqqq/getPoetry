package com.chajiu.service.Impl;

import com.chajiu.mapper.UserMapper;
import com.chajiu.pojo.User;
import com.chajiu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findOne(User user) {
        return userMapper.findOne(user);
    }

    @Override
    public void save(User user) throws Exception {
        if(user.getName()!=null && user.getUsername()!=null && user.getPassword()!=null && user.getEmail()!=null){  //为空判断
            if( userMapper.findOne(new User().name(user.getName()))!=null)  //name重复判断
                throw new Exception("昵称已存在");
            if(userMapper.findOne(new User().username(user.getUsername()))!=null)   //用户名重复判断
                throw new Exception("用户名已存在");
            userMapper.save(user);
        }else{
            throw new Exception("有内容未填写");
        }

    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public boolean check(User user) {
        int count=userMapper.check(user);
        if(count==0)
            return false;
        return true;
    }


}
