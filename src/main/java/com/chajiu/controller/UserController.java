package com.chajiu.controller;


import com.chajiu.pojo.User;
import com.chajiu.response.Response;
import com.chajiu.response.ResponseCodeType;
import com.chajiu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/user")
//@SessionAttributes(value = {"isLogin","loggedUser"}) //把登录标志和已登录用户放入SessionScope
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 用户登录
     * @param user
     * @param
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> login(@RequestBody User user, HttpSession session){
        Response<String> response=new Response<>();
        Boolean result=userService.check(user);     //检查用户名和密码
        if(result!=true){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage("账户不存在或密码错误");
        }else{
            session.setAttribute("isLogin",true);
            User loggedUser=userService.findOne(user);
            loggedUser.setPassword("");     //不返回密码
            session.setAttribute("loggedUser",loggedUser);
        }


        return response;
    }


    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> register(@RequestBody User user){
        Response<Boolean> response=new Response<>();
        try {
            userService.save(user);
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }

        return response;
    }


    /**
     * 检查是否登录，登录则返回用户信息，未登录返回ERROR
     * @param
     * @return
     */
    @RequestMapping(value = "/login/check",method = RequestMethod.GET)
    @ResponseBody
    public Response<User> getLoggedInfo(HttpSession session){
        Response<User> response=new Response<>();
        Boolean result=(Boolean) session.getAttribute("isLogin");    //获取isLogin属性
        if(result!=null && result==true){   //已登录
            User loggedUser=(User)session.getAttribute("loggedUser");

            System.out.println(loggedUser);

            response.setData(loggedUser);
        }else{  //未登录
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage("未登录");
        }
        return response;
    }

    /**
     * 用户登出
     * @param
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public Response<User> logout(HttpSession session){
        Response<User> response=new Response<>();
            session.removeAttribute("isLogin");
            session.removeAttribute("loggedUser");
        return response;
    }


    /**
     * 提交uid，和需要更改的部分即可
     * @param user
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public Response<String> update(@RequestBody User user,HttpSession session){
        Response<String> response=new Response<>();
        try {
            userService.update(user);

        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage("更新失败！");
        }
        return response;
    }






}
