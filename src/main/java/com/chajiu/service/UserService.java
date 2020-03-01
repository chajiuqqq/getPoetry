package com.chajiu.service;

import com.chajiu.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findOne(User user);
    void save(User user) throws Exception;
    void update(User user);
    void delete(Integer id);

    boolean check(User user);
}
