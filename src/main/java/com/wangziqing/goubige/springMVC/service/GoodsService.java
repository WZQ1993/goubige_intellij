package com.wangziqing.goubige.springMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangziqing.goubige.model.Good;
import com.wangziqing.goubige.mybatis.daoImp.GoodDaoImp;
@Service
public class GoodsService {
	@Autowired
	GoodDaoImp goodDaoImp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new GoodsService().getGoodByID("-1014442431");
	}
	public List<Good> getGoodByPage(int pageSize,int pageNum){
		//记录用户行为习惯
		//获取数据
		return goodDaoImp.getGoodByPage(pageSize,pageNum);
	}
	public Good getGoodByID(String ID){
		return goodDaoImp.getGoodByID(ID);
	}
}
