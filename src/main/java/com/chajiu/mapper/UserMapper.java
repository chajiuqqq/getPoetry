package com.chajiu.mapper;

import com.chajiu.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll();
    User findOne(User user);
    void save(User user);
    void update(User user);
    void delete(Integer id);
}
