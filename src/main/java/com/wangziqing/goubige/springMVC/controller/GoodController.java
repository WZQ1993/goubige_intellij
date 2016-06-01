package com.wangziqing.goubige.springMVC.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangziqing.goubige.model.Good;
import com.wangziqing.goubige.model.His;
import com.wangziqing.goubige.model.Star;
import com.wangziqing.goubige.springMVC.service.GoodService;
import com.wangziqing.goubige.springMVC.utils.LangsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Comment;

@Controller
@RequestMapping("/good")
public class GoodController {
	@Autowired
	GoodService goodService;
	@RequestMapping(value="",method=RequestMethod.GET)
	public void getGoods(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int pageSize,pageNum;
		List<Good> list;

		pageSize=LangsUtils.parseInt(request.getParameter("pageSize"),20);
		pageNum=LangsUtils.parseInt(request.getParameter("pageNum"),1);
		String tag= request.getParameter("tag");
		String categoryID=request.getParameter("categoryID");
		String method=request.getParameter("method");
		if(null!=categoryID){
			list=goodService.getGoodByCategory(pageSize,pageNum,Integer.valueOf(categoryID));
		}else{
			list=goodService.getGoodByPage(pageSize, pageNum);
		}
		if(null!=method){
			int userID=LangsUtils.parseInt(request.getParameter("userID"),0);
			switch (method){
				case "getStarGood":
					list=goodService.getStarGood(pageSize,pageNum,userID);
					break;
				case "getHistoryGood":
					list=goodService.getHistoryGood(pageSize,pageNum,userID);
					break;
				case "getRecommend":
					list=goodService.getRecommend(userID);
					break;
				default:
					break;
			}
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("tag",tag);
		jsonObject.put("list",list);
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
	@RequestMapping(value="/star",method=RequestMethod.GET)
	public  void starGood(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String tag =request.getParameter("tag");
		Star star= JSON.parseObject(request.getParameter("data"),Star.class);

		goodService.starGood(star);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("tag",tag);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().print(jsonObject.toString());

	}
	@RequestMapping(value="/hasStar",method=RequestMethod.GET)
	public void hasStar(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int code;
		String tag =request.getParameter("tag");
		Integer userID=Integer.valueOf(request.getParameter("userID"));
		Integer goodID=Integer.valueOf(request.getParameter("goodID"));
		//
		code=goodService.hasStar(userID,goodID)?0:1;
		//
		JSONObject jsonObject =new JSONObject();
		jsonObject.put("code",code);
		jsonObject.put("tag",tag);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().print(jsonObject.toString());
	}
	@RequestMapping(value="/his",method=RequestMethod.POST)
	public  void hisGood(HttpServletRequest request,HttpServletResponse response) throws IOException{
		His his= JSON.parseObject(request.getParameter("data"),His.class);
		goodService.hisGood(his);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
