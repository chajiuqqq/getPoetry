package com.chajiu.service.Impl;

import com.chajiu.mapper.FavourMapper;
import com.chajiu.pojo.Favour;
import com.chajiu.service.FavourService;
import com.chajiu.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavourServiceImpl implements FavourService {
    @Autowired
    FavourMapper mapper;
    @Override
    public List<Favour> findAllByUserId(Integer uid) {
        return this.findAllByUserId(uid,null);
    }

    @Override
    public List<Favour> findAllByUserId(Integer uid, Page page) {
        List<Favour> favourList = mapper.findAllByUserId(uid,page);
        for(Favour favour:favourList){
            favour.getPoetry().toSimpleInstance();
        }
        return favourList;
    }

    @Override
    public void save(Favour favour) throws Exception {
        if(mapper.exist(favour)==0)
            mapper.save(favour);
        else
            throw new Exception("已经收藏！");
    }

    @Override
    public void delete(Favour favour) {
        mapper.delete(favour);
    }

    @Override
    public Boolean exist(Favour favour) {
        Integer exist = mapper.exist(favour);
        return exist>=1?true:false;
    }
}
