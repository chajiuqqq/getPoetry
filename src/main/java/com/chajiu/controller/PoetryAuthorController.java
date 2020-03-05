package com.chajiu.controller;


import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.PoetryAuthor;
import com.chajiu.response.Response;
import com.chajiu.response.ResponseCodeType;
import com.chajiu.service.PoetryAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class PoetryAuthorController {

    @Autowired
    PoetryAuthorService service;

    /**
     * 依据id查找author 包含诗词
     * @param id
     * @return
     */
    @RequestMapping("/author/{id}")
    @ResponseBody
    public Response<PoetryAuthor> findOne(@PathVariable Integer id){
        Response<PoetryAuthor> response=new Response<>();
        try {
            PoetryAuthor author=service.findOne(id);
            response.setData(author);
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    /**
     * 查找所有作者 不包含诗词
     * @return
     */
    @RequestMapping("/authors")
    @ResponseBody
    public Response<List<PoetryAuthor>> findAll(){
        Response<List<PoetryAuthor>> response=new Response<>();
        try {
            List<PoetryAuthor> authors = service.findAll();
            response.setData(authors);
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

}
