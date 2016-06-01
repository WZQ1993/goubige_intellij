package com.wangziqing.goubige.springMVC.service;

import com.wangziqing.goubige.model.Support;
import com.wangziqing.goubige.mybatis.daoImp.SupportDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportService {
	@Autowired
	SupportDaoImp supportDaoImp;
	public void insert(Support support){
		supportDaoImp.insert(support);
	}

}
