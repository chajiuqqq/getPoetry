package com.chajiu.service.Impl;

import com.chajiu.mapper.PoetryMapper;
import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.PoetryAuthor;
import com.chajiu.service.PoetryService;
import com.chajiu.util.LangConverter;
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
    public Poetry findOne(Poetry poetry) throws Exception {
        String title=poetry.getTitle();
        if(title!=null){
            poetry.setTitle(LangConverter.toTradition(title));      //如果依据title查询，需要转为繁体，因为数据库里以繁体储存
        }

        Poetry foundPoetry;
        try {
            foundPoetry=poetryMapper.findOne(poetry);       //查询poetry
        }catch (Exception e){
            throw new Exception("重名诗词");
        }

        return foundPoetry.toSimpleInstance();      //返回简体化后的poetry

    }
}
