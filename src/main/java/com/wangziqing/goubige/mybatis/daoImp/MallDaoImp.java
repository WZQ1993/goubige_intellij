package com.wangziqing.goubige.mybatis.daoImp;

import com.google.common.collect.Lists;
import com.wangziqing.goubige.model.Mall;
import com.wangziqing.goubige.mybatis.daoBase.MallOperation;
import com.wangziqing.goubige.mybatis.daoBase.MySessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MallDaoImp {

	public void insert(Mall mall) {
		// TODO Auto-generated method stub
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			MallOperation mallOperation = session.getMapper(MallOperation.class);
			mallOperation.insert(mall);
			session.commit();
		} finally {
			session.close();
		}
	}
	public void insertAll(List<Mall> list){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			MallOperation mallOperation = session.getMapper(MallOperation.class);
			for (Mall mall:list){
				mall.setID(mall.getMall_id());
				mallOperation.insert(mall);
			}
			session.commit();
		} finally {
			session.close();
		}
	}
	public static void main(String[] args){
		List<Mall> list= Lists.newArrayList();
		for(int i=0;i<10;i++){
			Mall mall=new Mall();
			mall.setID(i);
			mall.setName("test");
			mall.setGoods_from(0);
			list.add(mall);
		}

		new MallDaoImp().insertAll(list);
	}
}
