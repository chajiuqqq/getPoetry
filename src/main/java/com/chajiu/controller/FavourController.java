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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class FavourController {
    @Autowired
    FavourService service;
    @Autowired
    PoetryService poetryService;

    User loggedUser=null;

    @ModelAttribute
    public void init(HttpSession session){
        loggedUser=(User)session.getAttribute("loggedUser");
    }

    /**
     * 分页查询所有收藏
     * @param start
     * @param count
     * @return
     */
    @RequestMapping(value = {"/favours","/favours/start/{start}/count/{count}"},method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Favour>> findAll(@PathVariable(required = false) Integer start, @PathVariable(required = false) Integer count){
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
        }catch (NullPointerException e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage("用户未登录");
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    /**
     * 添加收藏
     * @param pid
     * @return
     */
    @RequestMapping(value = "/favour/poetry/{pid}",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> save(@PathVariable Integer pid){
        Response<String> response=new Response<>();

        try {
            Favour favour=new Favour();
            favour.setUserId(loggedUser.getId());
            favour.setPoetryId(pid);
            favour.setCreateDate(new Date());
            service.save(favour);
        }catch (NullPointerException e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage("用户未登录");
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
    public Response<Map<String,Boolean>> exist(@PathVariable Integer pid){
        Response<Map<String,Boolean>> response=new Response<>();

        try {
            Favour favour=new Favour();
            favour.setUserId(loggedUser.getId());
            favour.setPoetryId(pid);

            Boolean result = service.exist(favour);
            Map<String,Boolean> map=new HashMap<>();
            map.put("hasFavour",result);
            response.setData(map);
        }catch (NullPointerException e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage("用户未登录");
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

        try {
            Favour favour=new Favour();
            favour.setUserId(loggedUser.getId());
            favour.setPoetryId(pid);
            favour.setCreateDate(new Date());
            service.delete(favour);
        }catch (NullPointerException e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage("用户未登录");
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;

    }




}
