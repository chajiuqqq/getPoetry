package com.chajiu.controller;


import com.chajiu.pojo.Favour;
import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.User;
import com.chajiu.response.Response;
import com.chajiu.response.ResponseCodeType;
import com.chajiu.service.FavourService;
import com.chajiu.service.PoetryService;
import com.chajiu.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api")
@SessionAttributes(value = {"isLogin","loggedUser"}) //把登录标志和已登录用户放入SessionScope
public class FavourController {
    @Autowired
    FavourService service;
    @Autowired
    PoetryService poetryService;

    User loggedUser;

    @ModelAttribute
    public void init(ModelMap map){
        loggedUser=(User)map.getAttribute("loggedUser");
    }

    @RequestMapping(value = {"/favours","/favours/start/{start}/count/{count}"},method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Favour>> findAll(@PathVariable(required = false) Integer start, @PathVariable(required = false) Integer count, ModelMap map){
        Response<List<Favour>> response=new Response<>();
        Page page=null;
        if(start!=null && count!=null) {
            page = new Page();
            page.setStart(start);
            page.setCount(count);
        }
        try {
            List<Favour> favours = service.findAllByUserId(loggedUser.getId(), page);
            response.setData(favours);
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;
    }
    @RequestMapping(value = "/favour/poetry/{pid}",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> save(@PathVariable Integer pid){
        Response<String> response=new Response<>();

        Poetry poetry=new Poetry();
        poetry.setId(pid);
        poetry = poetryService.findOne(poetry);

        Favour favour=new Favour();
        favour.setUserId(loggedUser.getId());
        favour.setPoetry(poetry);
        favour.setCreateDate(new Date());

        try {
            service.save(favour);
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;

    }

    /**
     * 判断是否已经收藏诗词
     * @param pid
     * @return
     */
    @RequestMapping(value = "/favour/poetry/{pid}",method = RequestMethod.GET)
    @ResponseBody
    public Response<Boolean> exist(@PathVariable Integer pid){
        Response<Boolean> response=new Response<>();

        Poetry poetry=new Poetry();
        poetry.setId(pid);
        poetry = poetryService.findOne(poetry);

        Favour favour=new Favour();
        favour.setUserId(loggedUser.getId());
        favour.setPoetry(poetry);
        favour.setCreateDate(new Date());

        try {
            Boolean result = service.exist(favour);
            response.setData(result);
            response.setMessage(result?"已收藏":"未收藏");
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;

    }

    /**
     * 取消收藏
     * @param pid
     * @return
     */
    @RequestMapping(value = "/favour/poetry/{pid}",method = RequestMethod.DELETE)
    @ResponseBody
    public Response<Boolean> delete(@PathVariable Integer pid){
        Response<Boolean> response=new Response<>();

        Poetry poetry=new Poetry();
        poetry.setId(pid);
        poetry = poetryService.findOne(poetry);

        Favour favour=new Favour();
        favour.setUserId(loggedUser.getId());
        favour.setPoetry(poetry);
        favour.setCreateDate(new Date());

        try {
           service.delete(favour);
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;

    }




}
