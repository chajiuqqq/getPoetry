package com.chajiu.service.Impl;

import com.chajiu.mapper.PoetryAuthorMapper;
import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.PoetryAuthor;
import com.chajiu.service.PoetryAuthorService;
import com.chajiu.util.LangConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoetryAuthorServiceImpl implements PoetryAuthorService {

    @Autowired
    PoetryAuthorMapper mapper;

    @Override
    public PoetryAuthor findOne(Integer id) {
       return mapper.findOne(id).toSimpleInstance();

    }

    @Override
    public List<PoetryAuthor> findAll() {
        List<PoetryAuthor> authors = mapper.findAll();
        for(PoetryAuthor author:authors){
            author.toSimpleInstance();
        }
        return authors;
    }

    @Override
    public List<PoetryAuthor> findLikeName(String name) {
        return mapper.findLikeName(name);
    }

    @Override
    public void createRecord() {
        List<PoetryAuthor> authors = mapper.findRecordCount();
        for(PoetryAuthor author:authors){
            mapper.update(author);
        }
    }

}
