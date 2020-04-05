package com.chajiu.service.Impl;

import com.chajiu.pojo.SearchResult;
import com.chajiu.service.CategoryService;
import com.chajiu.service.PoetryAuthorService;
import com.chajiu.service.PoetryService;
import com.chajiu.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchServiceImpl implements SearchService {
    @Autowired
    CategoryService categoryService;
    @Autowired
    PoetryService poetryService;
    @Autowired
    PoetryAuthorService authorService;

    @Override
    public SearchResult search(String in) {
        return search(in,5);
    }

    public SearchResult search(String in,int maxShowCount) {

        return null;
    }

}
