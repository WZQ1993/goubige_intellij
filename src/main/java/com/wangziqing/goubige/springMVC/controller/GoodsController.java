package com.wangziqing.goubige.springMVC.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.wangziqing.goubige.springMVC.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	GoodsService goodsService;
	@RequestMapping(value="",method=RequestMethod.GET)
	public void getGoods(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int pageSize,pageNum;
		pageSize=Integer.parseInt(request.getParameter("pageSize"));
		pageNum=Integer.parseInt(request.getParameter("pageNum"));
		System.out.println("接收到："+pageNum+"----"+pageSize);
		JSONObject jsonObject = new JSONObject(); 
		jsonObject.put("pageNum", pageNum);
		jsonObject.put("pageSize", pageSize);
		jsonObject.put("blockID", 1);
		jsonObject.put("tagID", 1);
		jsonObject.put("data", goodsService.getGoodByPage(pageSize, pageNum));
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.getWriter().print(jsonObject.toString());
	}
	
	@RequestMapping(value="/{ID}",method=RequestMethod.GET)
	public  void getGoodByID(@PathVariable String ID,HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.getWriter().print(JSONObject.toJSONString(goodsService.getGoodByID(ID)));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
