package com.chajiu.mapper;

import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.PoetryCategory;

import java.util.List;

public interface PoetryCategoryMapper {

    void save(PoetryCategory poetryCategory);
    List<Poetry> findPoetriesByCategory(Integer cid);
}
