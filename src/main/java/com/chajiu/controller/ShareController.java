package com.chajiu.controller;


import com.chajiu.pojo.Poetry;
import com.chajiu.response.Response;
import com.chajiu.response.ResponseCodeType;
import com.chajiu.service.PoetryService;
import com.chajiu.util.SharedImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class ShareController {
    @Autowired
    PoetryService service;

    @RequestMapping(value = "/share/{pid}",method = RequestMethod.GET)
    @ResponseBody
    public Response<Map<String,String>> getSharedImg(@PathVariable Integer pid){
        Response<Map<String,String>> response=new Response<>();
        URL classpath = this.getClass().getResource("/");   //  结果为  /E:/project/MyPoetry/target/MyPoetry/WEB-INF/classes/

        Poetry poetry=new Poetry();
        poetry.setId(pid);
        Poetry one = service.findOne(poetry);
        String url="http://poetry.chajiuqqq.cn/view/poem.html?titleid="+pid;

        try {
            System.out.println(classpath.getPath().substring(1));
            String imgName = SharedImgUtil.makeImg(one, url, classpath.getPath().substring(1));   //获取文件名

            String returnURL="/share/"+imgName; //获取路径
            Map<String,String> map=new HashMap<>();
            map.put("picLoc",returnURL);

            response.setData(map);
        } catch (Exception e) {
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
