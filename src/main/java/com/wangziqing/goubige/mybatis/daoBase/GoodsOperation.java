package com.wangziqing.goubige.mybatis.daoBase;

import com.wangziqing.goubige.model.Goods;
import com.wangziqing.goubige.model.PageBean;

import java.util.List;

public interface GoodsOperation {
	
	public void addGood(Goods good);
	
	public List<Goods> getGoodsByPage(PageBean pageBean);
	
	public Goods getGoodByID(String ID);
}
