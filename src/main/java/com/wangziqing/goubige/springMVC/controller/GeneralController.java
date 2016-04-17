package com.wangziqing.goubige.springMVC.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wangziqing.goubige.model.Sort;

@Controller
public class GeneralController {
//	@RequestMapping(value="/postJson",method=RequestMethod.POST)
//	public   @ResponseBody Object getJSON(@RequestBody String status) { 
//		System.out.println("接收POSTrequest");
//		System.out.println(status);
//		Map<String, Object> map=Maps.newHashMap();
//		JSONObject jsonObject = new JSONObject(); 
//	    List<Sort> sortList =Lists.newArrayList();
//	    sortList.add(new Sort(1, 2, "内容1"));
//	    sortList.add(new Sort(2, 2, "内容2"));
//	    sortList.add(new Sort(3, 2, "内容3"));
//	    jsonObject.put("status", status);
//	    jsonObject.put("data", sortList);
//	    map.put("status", 1);
//	    map.put("data",sortList);
//	    return map;
//	}  
	@RequestMapping(value="/postJson",method=RequestMethod.POST)
	public   @ResponseBody Object getJSON(HttpServletRequest request,HttpServletResponse response) throws IOException { 
		/*
		 * JavaScript出于安全方面的考虑，不允许跨域调用其他页面的对象
		 * Access-Control-Allow-Origin。
		 * HTTP响应头，指定服务器端允许进行跨域资源访问的来源域。
		 * 可以用通配符*表示允许任何域的JavaScript访问资源，
		 * 但是在响应一个携带身份信息(Credential)的HTTP请求时，
		 * Access-Control-Allow-Origin必需指定具体的域，不能用通配符。
		 * 
		 */
		response.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("接收POSTrequest");
		String status=request.getParameter("status");
		System.out.println(status);
		Map<String, Object> map=Maps.newHashMap();
		JSONObject jsonObject = new JSONObject(); 
	    List<Sort> sortList =Lists.newArrayList();
	    sortList.add(new Sort(1, 2, "内容1"));
	    sortList.add(new Sort(2, 2, "内容2"));
	    sortList.add(new Sort(3, 2, "内容3"));
	    jsonObject.put("status", status);
	    jsonObject.put("data", sortList);
	    map.put("data",sortList);
	    return map;
	}  
	@RequestMapping(value="/getJson",method=RequestMethod.GET)
	public void getJson(HttpServletRequest request,HttpServletResponse response) throws IOException{
		/*
		 * 取得url拼接的参数
		 * String userAccount = (String)request.getParameter("userAccount"); 
		 */
		JSONObject jsonObject = new JSONObject(); 
		List<Sort> sortList =Lists.newArrayList();
	    sortList.add(new Sort(1, 2, "内容1"));
	    sortList.add(new Sort(2, 2, "内容2"));
	    sortList.add(new Sort(3, 2, "内容3"));
	    jsonObject.put("totalItem", 3);
	    jsonObject.put("data", sortList);
	    //让浏览器用utf8来解析返回的数据
	    response.setHeader("Content-type", "text/html;charset=UTF-8"); 
	    response.getWriter().print(jsonObject.toString());
	}
	
}