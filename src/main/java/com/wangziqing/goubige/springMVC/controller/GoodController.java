package com.wangziqing.goubige.springMVC.controller;

import com.alibaba.fastjson.JSONObject;
import com.wangziqing.goubige.springMVC.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/good")
public class GoodController {
	@Autowired
	GoodService goodService;
	@RequestMapping(value="",method=RequestMethod.GET)
	public void getGoods(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int pageSize,pageNum;
		pageSize=Integer.parseInt(request.getParameter("pageSize"));
		pageNum=Integer.parseInt(request.getParameter("pageNum"));
		String tag= request.getParameter("tag");
		System.out.println("getGoods接收到："+pageNum+"----"+pageSize);
		JSONObject jsonObject = new JSONObject(); 
//		jsonObject.put("pageNum", pageNum);
//		jsonObject.put("pageSize", pageSize);
		jsonObject.put("code", 0);
		jsonObject.put("tag",tag);
		jsonObject.put("list", goodService.getGoodByPage(pageSize, pageNum));
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.getWriter().print(jsonObject.toString());
	}
	
	@RequestMapping(value="/{ID}",method=RequestMethod.GET)
	public  void getGoodByID(@PathVariable String ID,HttpServletRequest request,HttpServletResponse response) throws IOException{
		String tag= request.getParameter("tag");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("tag",tag);
		jsonObject.put("data",goodService.getGoodByID(ID));
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().print(jsonObject.toString());
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
