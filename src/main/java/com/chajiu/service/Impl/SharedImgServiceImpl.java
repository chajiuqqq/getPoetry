package com.chajiu.service.Impl;

import com.chajiu.mapper.SharedImgMapper;
import com.chajiu.pojo.SharedImg;
import com.chajiu.service.SharedImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SharedImgServiceImpl implements SharedImgService {
    @Autowired
    SharedImgMapper mapper;

    String prefix="/share/";    //默认前缀
    public void addPrefix(SharedImg img){
        img.setPicLoc(prefix+img.getFileName());
    }
    @Override
    public SharedImg find(Integer pid) {
        //给结果加上前缀，picLoc保存的是路径
        SharedImg img = mapper.find(pid);
        addPrefix(img);
        return img;
    }

    @Override
    public void save(SharedImg sharedImg) {
        mapper.save(sharedImg);
    }

    @Override
    public void delete(SharedImg sharedImg) {
        mapper.delete(sharedImg);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
