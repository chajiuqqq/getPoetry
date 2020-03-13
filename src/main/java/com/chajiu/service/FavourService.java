package com.chajiu.service;

import com.chajiu.pojo.Favour;
import com.chajiu.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavourService {
    List<Favour> findAllByUserId(Integer uid);
    List<Favour> findAllByUserId(Integer uid,Page page);
    void save(Favour favour) throws Exception;
    void delete(Favour favour);
    Boolean exist(Favour favour);
}
