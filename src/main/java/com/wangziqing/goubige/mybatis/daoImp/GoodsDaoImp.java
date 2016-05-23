package com.wangziqing.goubige.mybatis.daoImp;

import com.wangziqing.goubige.model.Goods;
import com.wangziqing.goubige.model.PageBean;
import com.wangziqing.goubige.mybatis.daoBase.GoodOperation;
import com.wangziqing.goubige.mybatis.daoBase.GoodsOperation;
import com.wangziqing.goubige.mybatis.daoBase.MySessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Repository 只能标注在 DAO 类上呢？
 * 这是因为该注解的作用不只是将类识别为Bean，
 * 同时它还能将所标注的类中抛出的数据访问异常封装为 Spring 的数据访问异常类型。
 * @author WZQ_PC
 *
 */
@Repository
public class GoodsDaoImp {

	public void addGood(Goods good) {
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			GoodsOperation goodOperation = session.getMapper(GoodsOperation.class);
			goodOperation.addGood(good);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void addGoods(List<Goods> goodList){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			GoodsOperation goodOperation = session.getMapper(GoodsOperation.class);
			for (Goods good : goodList) {
				goodOperation.addGood(good);
			}
			session.commit();
		} finally {
			session.close();
		}
	}
	public List<Goods> getGoodByPage(int pageSize,int pageNum){
		SqlSession session = MySessionFactoryUtil.getSession();
		int startRow=(pageNum-1)*pageSize;
		try {
			GoodsOperation goodOperation = session.getMapper(GoodsOperation.class);
			return goodOperation.getGoodsByPage(new PageBean(startRow,pageSize));
		} finally {
			session.close();
		}
	}
	public Goods getGoodByID(String ID){
		SqlSession session = MySessionFactoryUtil.getSession();
		return session.selectOne("com.wangziqing.goubige.mybatis.daoBase.GoodOperation.getGoodByID", ID);
	}
	 public static void main(String[] args) {

	 }

}
