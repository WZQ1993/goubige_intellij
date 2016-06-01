package com.wangziqing.goubige.springMVC.service;

import com.google.common.collect.Lists;
import com.wangziqing.goubige.model.Good;
import com.wangziqing.goubige.model.His;
import com.wangziqing.goubige.model.Star;
import com.wangziqing.goubige.mybatis.daoImp.GoodDaoImp;
import com.wangziqing.goubige.springMVC.utils.RecommentUtils;
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
	public List<Good> getGoodByCategory(int pageSize, int pageNum,int categoryID){
		return goodDaoImp.getGoodByCategory(pageSize,pageNum,categoryID);
	}
	public List<Good> getStarGood(int pageSize, int pageNum,int userID){
		return goodDaoImp.getStarGood(pageSize,pageNum,userID);
	}
	public List<Good> getHistoryGood(int pageSize, int pageNum,int userID){
		return goodDaoImp.getHistoryGood(pageSize,pageNum,userID);
	}
	public void starGood(Star star){
		goodDaoImp.starGood(star);
	}
	public Good getGoodByID(String ID){
		return goodDaoImp.getGoodByID(ID);
	}
	public boolean hasStar(int userID,int goodID){
		return goodDaoImp.hasStar(userID,goodID);
	}
	public void hisGood(His his){
		goodDaoImp.hisGood(his);
	}
	public List<Good> getRecommend(int userID){
		List<Integer> categoryIDs=goodDaoImp.getCategoryIDByUserID(userID);
		List<Good> result=Lists.newArrayList();
		if(categoryIDs.size()==0){
			for(int i=0;i<20;i++){
				result.add(goodDaoImp.getRand());
			}
		}
		else{
			int[] goodSize= RecommentUtils.getCountList(categoryIDs.size());
			for(int i=0;i<goodSize.length;i++){
				if(i==goodSize.length-1){
					for(int j=0;j<goodSize[i];j++){
						result.add(goodDaoImp.getRand());
					}
				}
				else{
					result.addAll(goodDaoImp.getRandByCategoryID(categoryIDs.get(i),goodSize[i]));
				}
			}
		}
		return result;
	}

}
