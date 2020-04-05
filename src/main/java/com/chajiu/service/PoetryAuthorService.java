package com.chajiu.service;

import com.chajiu.pojo.PoetryAuthor;

import java.util.List;

public interface PoetryAuthorService {
    PoetryAuthor findOne(Integer id);
    List<PoetryAuthor> findAll();
    List<PoetryAuthor> findLikeName(String name);
}
