package com.wangziqing.goubige.springMVC.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangziqing.goubige.model.Share;
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
import java.util.List;

/**
 * Created by WZQ_PC on 2016/5/16 0016.
 */
@Controller
@RequestMapping("/share")
public class ShareController {
    @Autowired
    ShareService shareService;
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void insert(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //tag,data
        //code,tag
        String tag= request.getParameter("tag");
        Share share=JSON.parseObject(request.getParameter("data"),Share.class);

        shareService.insert(share);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tag",tag);
        jsonObject.put("code",0);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }

    @RequestMapping(value = "/{ID}", method = RequestMethod.GET)
    public void getShareByID(
            @PathVariable int ID,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        Integer userID=request.getParameter("userID")==null?
                null:Integer.valueOf(request.getParameter("userID"));
        Share share=shareService.getShareByID(ID,userID);
        String tag= request.getParameter("tag");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("data", share);
        jsonObject.put("tag",tag);
        jsonObject.put("code",0);
        System.out.println(jsonObject.toString());
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }

    @RequestMapping(value="",method=RequestMethod.GET)
    public void getShareByPage(HttpServletRequest request,HttpServletResponse response) throws IOException{
        int pageSize,pageNum;
        List<Share> list;

        pageSize=Integer.parseInt(request.getParameter("pageSize"));
        pageNum=Integer.parseInt(request.getParameter("pageNum"));
        Integer requestID=request.getParameter("requestUserID")==null?
                0:Integer.valueOf(request.getParameter("requestUserID"));
        String userID=request.getParameter("userID");
        String tag= request.getParameter("tag");

        if(null!=userID){
            list=shareService.getShareByUser(pageSize,pageNum,requestID,Integer.valueOf(userID));
        }else{
            list=shareService.getShareByPage(pageSize,pageNum,requestID);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list",list);
        jsonObject.put("tag",tag);
        jsonObject.put("code",0);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }

    @RequestMapping(value = "/{ID}/supportNum", method = RequestMethod.POST)
    public void supportNumIncrease(
            @PathVariable int ID,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        shareService.supportNumIncrease(ID);
        String tag= request.getParameter("tag");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("tag",tag);
        System.out.println(jsonObject.toString());
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }

    @RequestMapping(value = "/{ID}/commentNum", method = RequestMethod.POST)
    public void commentNumIncrease(
            @PathVariable int ID,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        shareService.commentNumIncrease(ID);
        String tag= request.getParameter("tag");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("tag",tag);
        System.out.println(jsonObject.toString());
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }

}
