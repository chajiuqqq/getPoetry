package com.chajiu.service.Impl;

import com.chajiu.mapper.PoetryMapper;
import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.PoetryAuthor;
import com.chajiu.service.PoetryService;
import com.chajiu.util.LangConverter;
import com.chajiu.util.Page;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoetryServiceImpl implements PoetryService {

    @Autowired
    PoetryMapper poetryMapper;

    @Override
    public Poetry findOne(Poetry poetry){

        return  poetryMapper.findOne(poetry).toSimpleInstance();      //返回简体化后的poetry

    }

    @Override
    public List<Poetry> findLikeTitle(String title){
        return this.findLikeTitle(title,null);
    }

    @Override
    public List<Poetry> findLikeTitle(String title, Page page) {
        if(title!=null){
            title=LangConverter.toTradition(title);      //如果依据title查询，需要转为繁体，因为数据库里以繁体储存
        }
        List<Poetry> poetryList = poetryMapper.findLikeTitle(title,page);

        for(Poetry poetry:poetryList){
            poetry.toSimpleInstance();
        }
        return poetryList;
    }
}
