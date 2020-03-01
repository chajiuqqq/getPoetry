package com.chajiu.mapper;

import com.chajiu.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll();

    /**
     * 按照id-name-username依次寻找user
     * @param user
     * @return
     */
    User findOne(User user);
    void save(User user);

    /**
     * 只能更新name和密码
     * @param user
     */
    void update(User user);
    void delete(Integer id);

    /**
     * 检查用户名和密码是否匹配
     * @param user
     * @return
     */
    int check(User user);
}
