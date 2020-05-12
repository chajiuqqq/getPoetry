package com.chajiu.controller;

import com.chajiu.pojo.Category;
import com.chajiu.response.Response;
import com.chajiu.response.ResponseCodeType;
import com.chajiu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * CategoryController
 * @author chajiu
 * @date 2020/5/6
 */
@Controller
@RequestMapping("/api")
public class CategoryController {
    /** category服务层.*/
    @Autowired
    private CategoryService service;

    /**
     * 查找全部.
     * @return response
     */
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Category>> findAll() {
        Response<List<Category>> response = new Response<>();
        try {
            List<Category> list = service.findAll();
            response.setData(list);
        } catch (Exception e) {
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;
    }


    /**
     * 依据id查找一个分类.
     * @param id 分类的id
     * @return response
     */
    @RequestMapping(value = "/category/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Response<Category> findOne(@PathVariable(required = true) final Integer id) {
        Response<Category> response = new Response<>();

        try {
            Category category = service.findOne(id);
            response.setData(category);
        } catch (Exception e) {
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;


    }


    /**
     * 删除分类.
     * @param id 分类的id
     * @return response
     */
    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Response<String> delete(@PathVariable final Integer id) {
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
     * @param category 分类对象
     * @return response
     */
    @RequestMapping(value = "/category", method = RequestMethod.PUT)
    @ResponseBody
    public Response<String> update(@RequestBody Category category) {
        Response<String> response = new Response<>();
       try {
           service.update(category);
       } catch (Exception e) {
           response.setCode(ResponseCodeType.ERROR_500);
           response.setMessage(e.getMessage());
       }
        return response;
    }

    /**
     * 保存分类
     * @param category 分类对象
     * @return response
     */
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    @ResponseBody
    public Response<String> save(@RequestBody Category category) {
        Response<String> response = new Response<>();
        try {
            service.save(category);
        } catch (Exception e) {
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
