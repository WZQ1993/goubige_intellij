package com.wangziqing.goubige.springMVC.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangziqing.goubige.model.Fans;
import com.wangziqing.goubige.model.Support;
import com.wangziqing.goubige.springMVC.service.FansService;
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
@RequestMapping("/fans")
public class FansController {
    @Autowired
    FansService fansService;
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tag =request.getParameter("tag");
        //
        Fans fans=JSON.parseObject(request.getParameter("data"),Fans.class);
        fansService.insert(fans);
        //
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("tag",tag);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public void isFans(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int code;
        String tag =request.getParameter("tag");
        Integer userID=Integer.valueOf(request.getParameter("userID"));
        Integer fansID=Integer.valueOf(request.getParameter("fansID"));
        //
        code=fansService.isFans(userID,fansID)?0:1;
        //
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("tag",tag);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }
}
