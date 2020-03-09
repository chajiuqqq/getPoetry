package com.chajiu.controller;


import com.chajiu.pojo.Article;
import com.chajiu.response.Response;
import com.chajiu.response.ResponseCodeType;
import com.chajiu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/api")
public class ArticleController {
    @Autowired
    ArticleService service;

    @RequestMapping(value = "/article",method = RequestMethod.POST)
    @ResponseBody
    public Response<Map<String, Integer>> updateArticle(Article article, HttpServletRequest request){
        LocalDate date=LocalDate.now();
        String datePath="/"+date.getYear()+"/"+date.getMonth();
        Random rand=new Random();
        String articleName=date.toString().replaceAll("-","")+rand.nextInt(999999)+".json";
        String articlePath=request.getServletContext().getRealPath(datePath)+articleName;
        File file=new File(articlePath);
        Response<Map<String, Integer>> response=new Response<>();

        try(FileOutputStream outputStream=new FileOutputStream(file)){
            byte[] content=article.getContent().getBytes("utf-8");
            outputStream.write(content);
        }catch (Exception e){
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage("提交失败！");
            e.printStackTrace();
        }

        article.setPath(articlePath);
        service.save(article);

        Map<String,Integer> map=new HashMap<>();
        map.put("articleId",article.getId());

        response.setData(map);
        return response;

    }
}
