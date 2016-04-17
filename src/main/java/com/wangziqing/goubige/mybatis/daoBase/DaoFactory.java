package com.wangziqing.goubige.mybatis.daoBase;

import com.wangziqing.goubige.mybatis.daoImp.GoodDaoImp;

public class DaoFactory {
	
	public static GoodDaoImp getGoodDaoInstance(){
		return new GoodDaoImp();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
