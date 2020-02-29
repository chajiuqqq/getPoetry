package com.chajiu.service.Impl;

import com.chajiu.mapper.PoetryCategoryMapper;
import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.PoetryCategory;
import com.chajiu.response.Response;
import com.chajiu.response.ResponseCodeType;
import com.chajiu.service.PoetryCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PoetryCategoryServiceImpl implements PoetryCategoryService {

    @Autowired
    PoetryCategoryMapper mapper;

    @Override
    public Response<String> save(PoetryCategory poetryCategory) {
        Response<String> response=new Response<>();
        try {
            mapper.save(poetryCategory);
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setCode(ResponseCodeType.ERROR_500);
        }
        return response;
    }

    @Override
    public List<Poetry> findPoetriesByCategory(Integer cid) {
        List<Poetry> poetryList = mapper.findPoetriesByCategory(cid);
        for(Poetry poetry:poetryList){
            poetry.toSimpleInstance();
        }
        return poetryList;
    }
}
