package com.chajiu.controller;


import com.chajiu.pojo.SearchResult;
import com.chajiu.response.Response;
import com.chajiu.response.ResponseCodeType;
import com.chajiu.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class SearchController {
    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/search/{in}",method = RequestMethod.GET)
    @ResponseBody
    public Response<SearchResult> search(@PathVariable String in){

        Response<SearchResult> response=new Response<>();
        try {
            SearchResult result = searchService.search(in);
            response.setData(result);
        }catch (Exception e) {
            response.setCode(ResponseCodeType.ERROR_500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

}
