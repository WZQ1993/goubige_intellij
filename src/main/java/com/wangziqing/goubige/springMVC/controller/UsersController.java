package com.wangziqing.goubige.springMVC.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangziqing.goubige.springMVC.utils.LangsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangziqing.goubige.model.Users;
import com.wangziqing.goubige.springMVC.service.UsersService;

@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/exist", method = RequestMethod.GET)
    public void exist(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String tag = request.getParameter("tag");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",
                usersService.askUserIsExist(phone, email) > 0 ? 1 : 0);
        jsonObject.put("tag", tag);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        String tag = request.getParameter("tag");
        Users user = JSON.parseObject(request.getParameter("data"),
                Users.class);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tag", tag);
        user = usersService.getByPhoneAndEmail(user.getTelePhone(),
				user.getEmail(), user.getPassWord());
        if(null!=user){
            jsonObject.put("code", 0);
            jsonObject.put("data", user);
        }else{
            jsonObject.put("code", 1);
        }
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tag = request.getParameter("tag");
        Users user = JSON.parseObject(request.getParameter("data"),
                Users.class);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tag", tag);
        if (usersService.askUserIsExist(user.getTelePhone(), user.getEmail()) > 0) {
            jsonObject.put("code", 1);
        } else {
            usersService.addOrUpdate(user);
            jsonObject.put("code", 0);
            jsonObject.put("data", user);
        }
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void AddOrUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tag = request.getParameter("tag");
        Users user = JSON.parseObject(request.getParameter("data"),
                Users.class);
        usersService.addOrUpdate(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tag", tag);
        jsonObject.put("code", 0);
        jsonObject.put("data", user);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }

    @RequestMapping(value = "/userImg", method = RequestMethod.POST)
    public void uploadHeader(
            @RequestParam(value = "userImg", required = false) MultipartFile file,
            @RequestParam(value = "ID") int ID, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        // 调用上传文件
        System.out.println(file.getName());
        System.out.println(ID);
        usersService.updateheader(file.getInputStream(), ID);
    }
    @RequestMapping(value = "/{userID}", method = RequestMethod.GET)
    public void getUserDetailsByID(
            @PathVariable int userID,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        String tag = request.getParameter("tag");
        Users user = usersService.getByID(userID);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", user);
        jsonObject.put("tag", tag);
        jsonObject.put("code",0);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public void getUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int pageSize, pageNum;
        List<Users> list;
        pageSize = LangsUtils.parseInt(request.getParameter("pageSize"),10);
        pageNum = LangsUtils.parseInt(request.getParameter("pageNum"),1);
        String tag = request.getParameter("tag");
        String method=request.getParameter("method");
        method=method==null?"default":method;
        Integer userID=LangsUtils.parseInt(request.getParameter("userID"),0);

        switch (method){
            case "getFans":
                list=usersService.getFans(pageSize,pageNum,userID);
                break;
            case "getFollows":
                list=usersService.getFollows(pageSize,pageNum,userID);
                break;
            default:
                pageSize=pageNum==1?14:10;
                list=usersService.getUserByPage(pageSize, pageNum);
                break;
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", list);
        jsonObject.put("tag", tag);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print(jsonObject.toString());
    }


}
