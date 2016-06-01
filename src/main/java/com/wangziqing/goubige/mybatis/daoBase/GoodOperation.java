package com.wangziqing.goubige.mybatis.daoBase;

import com.wangziqing.goubige.model.*;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.List;

public interface GoodOperation {
	
	public void addGood(Good good);
	
	public List<Good> getGoodsByPage(PageBean pageBean);
	public List<Good> getGoodByCategory(int startRow, int pageSize,int categoryID);
	public Good getGoodByID(String ID);
	public void starGood(Star star);
	public int hasStar(int userID, int goodID);
	public void hisGood(His his);
	public List<Good> getStarGood(int startRow, int pageSize,int userID);
	public List<Good> getHistoryGood(int startRow, int pageSize,int userID);
	public void addAndUpdateScore(Score score);
	public int getCategoryID(int goodID);
	public List<Integer> getCategoryIDByUserID(int userID);
	public Good getRand();
	public List<Good> getRandByCategoryID(int categoryID,int size);
}
