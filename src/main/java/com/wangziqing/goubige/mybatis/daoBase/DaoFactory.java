package com.wangziqing.goubige.mybatis.daoBase;

import com.wangziqing.goubige.mybatis.daoImp.CategoryDaoImp;
import com.wangziqing.goubige.mybatis.daoImp.GoodDaoImp;
import com.wangziqing.goubige.mybatis.daoImp.MallDaoImp;

public class DaoFactory {
	private static CategoryDaoImp categoryDaoImp=new CategoryDaoImp();
	private static MallDaoImp mallDaoImp=new MallDaoImp();
	private static GoodDaoImp goodsDaoImp=new GoodDaoImp();
//	public static GoodDaoImp getGoodDaoInstance(){
//		return new GoodDaoImp();
//	}
	public static CategoryDaoImp getCategoryDaoImp(){
		return categoryDaoImp;
	}
	public static MallDaoImp getMallDaoImp(){
		return mallDaoImp;
	}
	public static GoodDaoImp getGoodDaoImp(){
		return goodsDaoImp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
