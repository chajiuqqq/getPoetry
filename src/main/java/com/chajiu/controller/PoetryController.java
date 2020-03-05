package com.chajiu.controller;

import com.chajiu.pojo.Poetry;
import com.chajiu.response.Response;
import com.chajiu.response.ResponseCodeType;
import com.chajiu.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class PoetryController {

    @Autowired
    PoetryService service;

    /**
     * 依据id或者title寻找poetry，返回诗 作者 对应分类集合
     * @param id
     * @param title
     * @return
     */
    @RequestMapping(value = {"/poetry/id/{id}","/poetry/title/{title}"},method = RequestMethod.GET)
    @ResponseBody
    public Response<Poetry> findOne(
            @PathVariable(required = false) Integer id,
            @PathVariable(required = false) String title){
        Response<Poetry> response=new Response<>();

        Poetry poetry=new Poetry();
        poetry.setId(id);
        poetry.setTitle(title);

        Poetry foundPoetry;
        try {
            foundPoetry=service.findOne(poetry);
            foundPoetry.getPoetryAuthor().setPoetries(null);    //查一首诗时，只需要作者信息，不需要他的其他诗作
            response.setData(foundPoetry);
        } catch (Exception e) {
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }

        return response;
    }
}
