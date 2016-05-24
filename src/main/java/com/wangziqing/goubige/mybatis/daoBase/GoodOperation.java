package com.wangziqing.goubige.mybatis.daoBase;

import com.wangziqing.goubige.model.Good;
import com.wangziqing.goubige.model.PageBean;

import java.util.List;

public interface GoodOperation {
	
	public void addGood(Good good);
	
	public List<Good> getGoodsByPage(PageBean pageBean);
	
	public Good getGoodByID(String ID);
}
