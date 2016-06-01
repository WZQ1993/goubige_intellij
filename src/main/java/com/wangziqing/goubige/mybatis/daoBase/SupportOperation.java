package com.wangziqing.goubige.mybatis.daoBase;


import com.wangziqing.goubige.model.Support;

public interface SupportOperation {
	public void insert(Support support);
	public int isSupport(int shareID,int userID);
}
