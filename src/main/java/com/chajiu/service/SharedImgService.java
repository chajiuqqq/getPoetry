package com.chajiu.service;

import com.chajiu.pojo.SharedImg;

public interface SharedImgService {
    SharedImg find(Integer pid);
    void save(SharedImg sharedImg);
    void delete(SharedImg sharedImg);
    void addPrefix(SharedImg img);
}
