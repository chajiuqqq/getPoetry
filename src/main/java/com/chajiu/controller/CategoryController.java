package com.chajiu.controller;

import com.chajiu.pojo.Category;
import com.chajiu.response.Response;
import com.chajiu.response.ResponseCodeType;
import com.chajiu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Controller
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService service;

    /**
     * 查找全部
     * @return
     */
    @RequestMapping(value = "/categories",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Category>> findAll(){
        Response<List<Category>> response=new Response<>();
        try {
            List<Category> list = service.findAll();
            response.setData(list);
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;
    }


    /**
     * 依据id查找一个分类
     * @param
     * @return
     */
    @RequestMapping(value = "/category/id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Response<Category> findOne(@PathVariable(required = true) Integer id){
        Response<Category> response=new Response<>();

        try {
            Category category = service.findOne(id);
            response.setData(category);
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;


    }


    /**
     * 模糊查询分类
     * @return
     */
    @RequestMapping(value = "/category/name/{name}",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Category>> findPossibleCategory(@PathVariable String name){
        Response<List<Category>> response=new Response<>();
        try {
            List<Category> categoryList = service.findPossibleCategory(name);
            response.setData(categoryList);
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;
    }


    /**
     * 删除分类
     * @param id
     * @return
     */
    @RequestMapping(value = "/category/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Response<String> delete(@PathVariable Integer id){
        Response<String> response=new Response<>();
        try {
            service.delete(id);
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    /**
     * 更新分类
     * @param category
     * @return
     */
    @RequestMapping(value = "/category",method = RequestMethod.PUT)
    @ResponseBody
    public Response<String> update(@RequestBody Category category){
        Response<String> response=new Response<>();
       try {
           service.update(category);
       }catch (Exception e){
           response.setCode(ResponseCodeType.ERROR_500);
           response.setMessage(e.getMessage());
       }
        return response;
    }

    /**
     * 保存分类
     * @param category
     * @return
     */
    @RequestMapping(value = "/category",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> save(@RequestBody Category category){
        Response<String> response=new Response<>();
        try {
            service.save(category);
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
