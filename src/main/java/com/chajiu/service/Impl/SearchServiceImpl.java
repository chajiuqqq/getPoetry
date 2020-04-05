package com.chajiu.service.Impl;

import com.chajiu.pojo.Category;
import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.PoetryAuthor;
import com.chajiu.pojo.SearchResult;
import com.chajiu.service.CategoryService;
import com.chajiu.service.PoetryAuthorService;
import com.chajiu.service.PoetryService;
import com.chajiu.service.SearchService;
import com.chajiu.util.LangConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    CategoryService categoryService;
    @Autowired
    PoetryService poetryService;
    @Autowired
    PoetryAuthorService authorService;

    @Override
    public SearchResult search(String in) {
        return search(in,3);
    }

    public SearchResult search(String in,int maxShowCount) {
        List<Category> categories = categoryService.findPossibleCategory(in);
        categories=categories.subList(0,Integer.min(maxShowCount,categories.size()));   //取前三个结果

        List<Poetry> poetries = poetryService.findLikeTitle(LangConverter.toTradition(in));
        poetries=poetries.subList(0,Integer.min(maxShowCount,poetries.size()));     //取前三个结果

        List<PoetryAuthor> authors = authorService.findLikeName(LangConverter.toTradition(in));
        authors=authors.subList(0,Integer.min(maxShowCount,authors.size()));        //取前三个结果

        //简化
        for(Poetry poetry:poetries){
            poetry.toSimpleInstance();
        }
        for(PoetryAuthor author:authors){
            author.toSimpleInstance();
        }

        SearchResult result=new SearchResult();
        result.setCategories(categories);
        result.setPoetries(poetries);
        result.setAuthors(authors);

        return result;
    }

}
