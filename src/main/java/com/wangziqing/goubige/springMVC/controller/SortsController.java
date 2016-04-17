package com.wangziqing.goubige.springMVC.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.wangziqing.goubige.model.Sort;
import com.wangziqing.goubige.springMVC.service.SortsService;

@Controller
@RequestMapping("/sorts")
public class SortsController {
	private static List<Sort> BIG_SORTS=Lists.newArrayList();
	@Autowired
	SortsService sortsService;
	@RequestMapping(value="",method=RequestMethod.GET)
	public void getBigSorts(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("BigSorts请求");
		if(BIG_SORTS.size()==0){
			initBigSorts();
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", BIG_SORTS);
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.getWriter().print(jsonObject.toString());
	}
	private void initBigSorts(){
//		System.out.println("initBigSorts");
		BIG_SORTS=sortsService.getBigSorts();
	}
}
