package com.wangziqing.goubige.springMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangziqing.goubige.model.Sort;
import com.wangziqing.goubige.mybatis.daoImp.SortDaoImp;

@Service
public class SortsService {
	@Autowired
	SortDaoImp sortDaoImp;
	public List<Sort> getBigSorts(){
		return sortDaoImp.getBigSorts();
	}
	
}
