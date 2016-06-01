package com.wangziqing.goubige.mybatis.daoImp;

import com.wangziqing.goubige.model.*;
import com.wangziqing.goubige.mybatis.daoBase.GoodOperation;
import com.wangziqing.goubige.mybatis.daoBase.MySessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodDaoImp {

	public void addGood(Good good) {
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			GoodOperation goodOperation = session.getMapper(GoodOperation.class);
			goodOperation.addGood(good);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void addGoods(List<Good> goodList){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			GoodOperation goodOperation = session.getMapper(GoodOperation.class);
			for (Good good : goodList) {
				goodOperation.addGood(good);
			}
			session.commit();
		} finally {
			session.close();
		}
	}
	public List<Good> getGoodByPage(int pageSize, int pageNum){
		SqlSession session = MySessionFactoryUtil.getSession();
		int startRow=(pageNum-1)*pageSize;
		try {
			GoodOperation goodOperation = session.getMapper(GoodOperation.class);
			return goodOperation.getGoodsByPage(new PageBean(startRow,pageSize));
		} finally {
			session.close();
		}
	}
	public List<Good> getGoodByCategory(int pageSize, int pageNum,int categoryID){
		SqlSession session = MySessionFactoryUtil.getSession();
		int startRow=(pageNum-1)*pageSize;
		try {
			GoodOperation goodOperation = session.getMapper(GoodOperation.class);
			return goodOperation.getGoodByCategory(startRow,pageSize,categoryID);
		} finally {
			session.close();
		}
	}
	public Good getGoodByID(String ID){
		SqlSession session = MySessionFactoryUtil.getSession();
		return session.selectOne("com.wangziqing.goubige.mybatis.daoBase.GoodOperation.getGoodByID", ID);
	}
	public void starGood(Star star){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			GoodOperation goodOperation = session.getMapper(GoodOperation.class);
			Score score=new Score();
			score.setUserID(star.getUserID());
			score.setCategoryID(goodOperation.getCategoryID(star.getGoodID()));
			score.setScore(2);
			goodOperation.addAndUpdateScore(score);
			goodOperation.starGood(star);
			session.commit();
		} finally {
			session.close();
		}
	}
	public boolean hasStar(int userID,int goodID){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			GoodOperation goodOperation = session.getMapper(GoodOperation.class);
			return goodOperation.hasStar(userID,goodID)>0?true:false;
		} finally {
			session.close();
		}
	}
	public void hisGood(His his){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			GoodOperation goodOperation = session.getMapper(GoodOperation.class);
			Score score=new Score();
			score.setUserID(his.getUserID());
			score.setCategoryID(goodOperation.getCategoryID(his.getGoodID()));
			score.setScore(1);
			goodOperation.addAndUpdateScore(score);
			goodOperation.hisGood(his);
			session.commit();
		} finally {
			session.close();
		}
	}
	public List<Good> getStarGood(int pageSize, int pageNum,int userID){
		SqlSession session = MySessionFactoryUtil.getSession();
		int startRow=(pageNum-1)*pageSize;
		try {
			GoodOperation goodOperation = session.getMapper(GoodOperation.class);
			return goodOperation.getStarGood(startRow,pageSize,userID);
		} finally {
			session.close();
		}
	}
	public List<Good> getHistoryGood(int pageSize, int pageNum,int userID){
		SqlSession session = MySessionFactoryUtil.getSession();
		int startRow=(pageNum-1)*pageSize;
		try {
			GoodOperation goodOperation = session.getMapper(GoodOperation.class);
			return goodOperation.getHistoryGood(startRow,pageSize,userID);
		} finally {
			session.close();
		}
	}
	public List<Integer> getCategoryIDByUserID(int userID){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			GoodOperation goodOperation = session.getMapper(GoodOperation.class);
			return goodOperation.getCategoryIDByUserID(userID);
		} finally {
			session.close();
		}
	}
	public List<Good> getRandByCategoryID(int categoryID,int size){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			GoodOperation goodOperation = session.getMapper(GoodOperation.class);
			return goodOperation.getRandByCategoryID(categoryID,size);
		} finally {
			session.close();
		}
	}
	public Good getRand(){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			GoodOperation goodOperation = session.getMapper(GoodOperation.class);
			return goodOperation.getRand();
		} finally {
			session.close();
		}
	}
	 public static void main(String[] args) {

	 }

}
