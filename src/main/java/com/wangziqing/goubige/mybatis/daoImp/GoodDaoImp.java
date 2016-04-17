package com.wangziqing.goubige.mybatis.daoImp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.wangziqing.goubige.model.Good;
import com.wangziqing.goubige.model.PageBean;
import com.wangziqing.goubige.mybatis.daoBase.GoodOperation;
import com.wangziqing.goubige.mybatis.daoBase.MySessionFactoryUtil;
/**
 * @Repository 只能标注在 DAO 类上呢？
 * 这是因为该注解的作用不只是将类识别为Bean，
 * 同时它还能将所标注的类中抛出的数据访问异常封装为 Spring 的数据访问异常类型。
 * @author WZQ_PC
 *
 */
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
	public List<Good> getGoodByPage(int pageSize,int pageNum){
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
//		 GoodDaoImp goodDaoImp=new GoodDaoImp();
//	 Good good=new Good();
//	 good.setID("ID");
//	 good.setTitle("标题");
//	 good.setUrl("saafd");
//	 good.setPic("图片");
//	 good.setSold(10);
//	 good.setPriceCurrent(100);
//	 good.setPriceOld(100);
//	 good.setDiscount((byte) 1);
//	 good.setFrom(1);
//	 good.setBlockId(1);
//	 good.setTagId(1);
//	 new GoodDaoImp().addGood(good);
//	 System.out.println(goodDaoImp.getGoods(10, 1).size());
//		System.out.println(goodDaoImp.getGoodByID("-1014442431").getID());
	 }

}
