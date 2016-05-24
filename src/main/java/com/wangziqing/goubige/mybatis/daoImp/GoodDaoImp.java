package com.wangziqing.goubige.mybatis.daoImp;

import com.wangziqing.goubige.model.Good;
import com.wangziqing.goubige.model.PageBean;
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
	public Good getGoodByID(String ID){
		SqlSession session = MySessionFactoryUtil.getSession();
		return session.selectOne("com.wangziqing.goubige.mybatis.daoBase.GoodOperation.getGoodByID", ID);
	}
	 public static void main(String[] args) {

	 }

}
