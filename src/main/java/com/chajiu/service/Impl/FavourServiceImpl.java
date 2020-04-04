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
            favour.getPoetry().setPoetryAuthor(null);   //不返回作者的详细信息
            favour.getPoetry().toSimpleInstance();
        }
        return favourList;
    }

    @Override
    public void save(Favour favour) throws Exception {
        if(mapper.exist(favour)==0)
            mapper.save(favour);
        else
            throw new Exception("诗词编号："+favour.getPoetryId()+" 已经收藏！");
    }

    @Override
    public void delete(Favour favour) throws Exception {
        if(mapper.exist(favour)!=0)
            mapper.delete(favour);
        else
            throw new Exception("诗词编号："+favour.getPoetryId()+" 已经取消收藏！");
    }

    @Override
    public Boolean exist(Favour favour) {
        Integer exist = mapper.exist(favour);
        return exist>=1?true:false;
    }
}
