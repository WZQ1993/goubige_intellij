package com.wangziqing.goubige.mybatis.daoImp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.wangziqing.goubige.model.Sort;
import com.wangziqing.goubige.mybatis.daoBase.MySessionFactoryUtil;
import com.wangziqing.goubige.mybatis.daoBase.SortOperation;
@Repository
public class SortDaoImp  {

	public void addSort(Sort sort) {
		// TODO Auto-generated method stub
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			SortOperation sortOperation = session.getMapper(SortOperation.class);
			sortOperation.addSort(sort);
			session.commit();
		} finally {
			session.close();
		}
	}
	public void addSorts(List<Sort> sortList) {
		// TODO Auto-generated method stub
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			SortOperation sortOperation = session.getMapper(SortOperation.class);
			for (Sort sort : sortList) {
				sortOperation.addSort(sort);
			}
			session.commit();
		} finally {
			session.close();
		}
	}
	public List<Sort> getBigSorts(){
		SqlSession session = MySessionFactoryUtil.getSession();
		List<Sort> sorts=Lists.newArrayList();
		try {
			SortOperation sortOperation = session.getMapper(SortOperation.class);
			sorts=sortOperation.getBigSorts();
		} finally {
			session.close();
		}
		return sorts;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<Sort> sortList=new ArrayList<>();
//		for (chePinHuWai item : SortUtil.chePinHuWai.values()) {
//			Sort sort=new Sort();
//			sort.setID(Integer.parseInt(item.getTagID()));
//			sort.setUpperId(Integer.parseInt(item.getBlockID()));
//			sort.setContent(item.getTagValue());
//			sortList.add(sort);
//		}
		List<Sort> sorts=new SortDaoImp().getBigSorts();
		for (Sort sort : sorts) {
			System.out.println(sort.toString());
		}
	}

}
