package com.wangziqing.goubige.mybatis.daoBase;


import com.wangziqing.goubige.model.Fans;

public interface FansOperation {
	public void insert(Fans fans);
	public int isFans(int userID, int fansID);
}
