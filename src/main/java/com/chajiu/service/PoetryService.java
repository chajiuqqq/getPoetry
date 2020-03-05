package com.chajiu.service;

import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.PoetryAuthor;
import org.apache.ibatis.exceptions.TooManyResultsException;

import java.util.List;

public interface PoetryService {
    Poetry findOne(Poetry poetry) throws Exception;


}
