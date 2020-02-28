package com.chajiu.service;

import com.chajiu.pojo.PoetryCategory;
import com.chajiu.response.Response;

public interface PoetryCategoryService {
    Response<String> save(PoetryCategory poetryCategory);
}
