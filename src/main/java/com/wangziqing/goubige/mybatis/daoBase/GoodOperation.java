package com.wangziqing.goubige.mybatis.daoBase;

import java.util.List;


import com.wangziqing.goubige.model.Good;
import com.wangziqing.goubige.model.PageBean;

public interface GoodOperation {
	
	public void addGood(Good good);
	
	public List<Good> getGoodsByPage(PageBean pageBean);
	
	public Good getGoodByID(String ID);
}
