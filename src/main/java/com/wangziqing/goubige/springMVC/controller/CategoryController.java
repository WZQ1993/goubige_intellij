package com.wangziqing.goubige.springMVC.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangziqing.goubige.model.Share;
import com.wangziqing.goubige.springMVC.service.CategoryService;
import com.wangziqing.goubige.springMVC.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WZQ_PC on 2016/5/16 0016.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value="",method=RequestMethod.GET)
    public void getCategory(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String tag= request.getParameter("tag");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list",categoryService.getCategorys());
        jsonObject.put("tag",tag);
        jsonObject.put("code",0);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }

}
