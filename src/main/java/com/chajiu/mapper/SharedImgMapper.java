package com.chajiu.mapper;

import com.chajiu.pojo.SharedImg;
import org.apache.ibatis.annotations.Param;

public interface SharedImgMapper {
    SharedImg find(@Param("pid") Integer pid);
    void save(SharedImg sharedImg);
    void delete(SharedImg sharedImg);

}
