package com.wangziqing.goubige.springMVC.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangziqing.goubige.model.Comment;
import com.wangziqing.goubige.model.Share;
import com.wangziqing.goubige.springMVC.service.CommentService;
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
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void insert(@RequestBody String JsonString, HttpServletResponse response)
            throws IOException {
        //tag,data
        //tag.data.code
        JSONObject jsonObject = JSON.parseObject(JsonString);
        Comment comment=JSON.parseObject(jsonObject.get("data").toString(),Comment.class);
        commentService.insert(comment);
        jsonObject.put("code",0);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }

    @RequestMapping(value="",method=RequestMethod.GET)
    public void getByPage(HttpServletRequest request,HttpServletResponse response) throws IOException{
        int pageSize,pageNum,shareID;
        pageSize=Integer.parseInt(request.getParameter("pageSize"));
        pageNum=Integer.parseInt(request.getParameter("pageNum"));
        shareID=Integer.parseInt(request.getParameter("shareID"));
        String tag= request.getParameter("tag");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list",commentService.getByPage(pageSize,pageNum,shareID));
        jsonObject.put("tag",tag);
        jsonObject.put("code",0);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }
}
