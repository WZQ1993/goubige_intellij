package com.wangziqing.goubige.springMVC.service;

import com.wangziqing.goubige.model.Fans;
import com.wangziqing.goubige.model.Support;
import com.wangziqing.goubige.mybatis.daoImp.FansDaoImp;
import com.wangziqing.goubige.mybatis.daoImp.SupportDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FansService {
	@Autowired
	FansDaoImp fansDaoImp;
	public void insert(Fans fans){
		fansDaoImp.insert(fans);
	}

	public boolean isFans(int userID,int fansID){
		return fansDaoImp.isFans(userID,fansID);
	}

}
