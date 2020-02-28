package com.chajiu.controller;

import com.chajiu.pojo.Category;
import com.chajiu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CategoryController {
    @Autowired
    CategoryService service;

    /**
     * 查找全部
     * @return
     */
    @RequestMapping(value = "/categories",method = RequestMethod.GET)
    @ResponseBody
    public List<Category> findAll(){
        List<Category> list = service.findAll();
        return list;
    }

    /**
     * 查找一个分类
     * @param id
     * @return
     */
    @RequestMapping(value = "/category/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Category findOne(@PathVariable Integer id){
        Category category=new Category();
        category.setId(id);
        category=service.findOne(category);
        return category;
    }


    /**
     * 删除分类
     * @param id
     * @return
     */
    @RequestMapping(value = "/category/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "ok";
    }

    /**
     * 更新分类
     * @param category
     * @return
     */
    @RequestMapping(value = "/category",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody Category category){
        service.update(category);
        return "ok";
    }

    /**
     * 保存分类
     * @param category
     * @return
     */
    @RequestMapping(value = "/category",method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody Category category){
        service.save(category);
        return "ok";
    }
}
