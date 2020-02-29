package com.chajiu.service;

import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.PoetryCategory;
import com.chajiu.response.Response;

import java.util.List;

public interface PoetryCategoryService {
    Response<String> save(PoetryCategory poetryCategory);
    List<Poetry> findPoetriesByCategory(Integer cid);
}
