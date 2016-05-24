package com.wangziqing.goubige.springMVC.service;

import com.wangziqing.goubige.model.Good;
import com.wangziqing.goubige.mybatis.daoImp.GoodDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
	@Autowired
	GoodDaoImp goodDaoImp;

	public List<Good> getGoodByPage(int pageSize, int pageNum){
		//记录用户行为习惯
		//获取数据
		return goodDaoImp.getGoodByPage(pageSize,pageNum);
	}
	public Good getGoodByID(String ID){
		return goodDaoImp.getGoodByID(ID);
	}
}
