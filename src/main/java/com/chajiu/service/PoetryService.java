package com.chajiu.service;

import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.PoetryAuthor;
import com.chajiu.util.Page;
import org.apache.ibatis.exceptions.TooManyResultsException;

import java.util.List;

public interface PoetryService {
    Poetry findOne(Poetry poetry);
    List<Poetry> findLikeTitle(String title);

    List<Poetry> findLikeTitle(String title,Page page);

}
