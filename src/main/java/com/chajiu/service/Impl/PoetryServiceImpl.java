package com.chajiu.service.Impl;

import com.chajiu.mapper.PoetryMapper;
import com.chajiu.pojo.Poetry;
import com.chajiu.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;

public class PoetryServiceImpl implements PoetryService {

    @Autowired
    PoetryMapper poetryMapper;

    @Override
    public Poetry findOne(Poetry poetry) {
        return poetryMapper.findOne(poetry);
    }
}
