package com.chajiu.mapper;

import com.chajiu.pojo.Favour;
import com.chajiu.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavourMapper {
    List<Favour> findAllByUserId(@Param("uid") Integer uid,@Param("page") Page page);
    void save(Favour favour);
    void delete(Favour favour);

    Integer exist(Favour favour);

}
