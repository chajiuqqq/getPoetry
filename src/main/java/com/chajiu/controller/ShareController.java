package com.chajiu.controller;


import com.chajiu.pojo.Poetry;
import com.chajiu.pojo.SharedImg;
import com.chajiu.response.Response;
import com.chajiu.response.ResponseCodeType;
import com.chajiu.service.PoetryService;
import com.chajiu.service.SharedImgService;
import com.chajiu.util.DateUtil;
import com.chajiu.util.SharedImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class ShareController {
    @Autowired
    PoetryService service;
    @Autowired
    SharedImgService sharedImgService;

    @RequestMapping(value = "/share/{pid}",method = RequestMethod.GET)
    @ResponseBody
    public Response<SharedImg> getSharedImg(@PathVariable Integer pid){
        Response<SharedImg> response=new Response<>();
        URL classpath = this.getClass().getResource("/");   //  结果为  /E:/project/MyPoetry/target/MyPoetry/WEB-INF/classes/
        SharedImg imgRecord=null;
        try {
            imgRecord = sharedImgService.find(pid);
            if(!DateUtil.isSameDay(imgRecord.getDate(),new Date())){   //不是今天的图片则删除记录，并重新生成图片
                sharedImgService.delete(imgRecord);
                throw new NullPointerException();
            }
            response.setData(imgRecord);
        }catch (NullPointerException e) {
            Poetry poetry=new Poetry();
            poetry.setId(pid);
            Poetry one = service.findOne(poetry);
            String url="http://poetry.chajiuqqq.cn/view/poem.html?titleid="+pid;

            try {
                System.out.println(classpath.getPath().substring(1));
                String imgName = SharedImgUtil.makeImg(one, url, classpath.getPath().substring(1));   //生成图片并获取文件名

                imgRecord= new SharedImg(pid, imgName);
                sharedImgService.addPrefix(imgRecord);  //给imgRecord生成returnURL
                sharedImgService.save(imgRecord);  //保存img到数据库
                response.setData(imgRecord);

            } catch (Exception e2) {
                response.setCode(ResponseCodeType.ERROR_500);
                response.setMessage(e2.getMessage());
            }
        }


        return response;
    }
}
