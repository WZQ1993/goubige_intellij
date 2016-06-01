package com.wangziqing.goubige.springMVC.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangziqing.goubige.model.Comment;
import com.wangziqing.goubige.model.Support;
import com.wangziqing.goubige.springMVC.service.CommentService;
import com.wangziqing.goubige.springMVC.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WZQ_PC on 2016/5/16 0016.
 */
@Controller
@RequestMapping("/support")
public class SupportController {
    @Autowired
    SupportService supportService;
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //tag,data
        //tag.data.code
        String tag =request.getParameter("tag");
        Support support=JSON.parseObject(request.getParameter("data"),Support.class);
        supportService.insert(support);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("tag",tag);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }
}
