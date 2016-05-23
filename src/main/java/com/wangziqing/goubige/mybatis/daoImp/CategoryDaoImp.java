package com.wangziqing.goubige.mybatis.daoImp;

import com.google.common.collect.Lists;
import com.wangziqing.goubige.model.Category;
import com.wangziqing.goubige.mybatis.daoBase.CategoryOperation;
import com.wangziqing.goubige.mybatis.daoBase.MySessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImp {

	public void insert(Category category) {
		// TODO Auto-generated method stub
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			CategoryOperation categoryOperation = session.getMapper(CategoryOperation.class);
			categoryOperation.insert(category);
			session.commit();
		} finally {
			session.close();
		}
	}
	public void insertAll(List<Category> list){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			CategoryOperation categoryOperation = session.getMapper(CategoryOperation.class);
			for (Category category : list) {
				categoryOperation.insert(category);
			}
			session.commit();
		} finally {
			session.close();
		}
	}
	public List<Category> getCategorys(){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			CategoryOperation categoryOperation=session.getMapper(CategoryOperation.class);
			return categoryOperation.getCategorys();
		} finally {
			session.close();
		}
	}
	public static void main(String[] args){
		CategoryDaoImp categoryDaoImp=new CategoryDaoImp();
		List<Category> list= Lists.newArrayList();
		for(int i=0;i<10;i++){
			Category category=new Category();
			category.setID(i);
			category.setTitle("jingdong");
			category.setUrl_nicktitle("jingdong");
			list.add(category);
		}
		categoryDaoImp.insertAll(list);
	}
}
