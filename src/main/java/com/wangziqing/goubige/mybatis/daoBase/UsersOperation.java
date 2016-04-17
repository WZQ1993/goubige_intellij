package com.wangziqing.goubige.mybatis.daoBase;

import com.wangziqing.goubige.model.Users;

public interface UsersOperation {
	public void insert(Users user);
	public void update(Users user);
	public Users getByID(int ID);
	public Integer getIDByPhoneAndEmail(String telePhone,String email);
	public Users getByPhoneAndEmail(String telePhone,String email,String passWord);
	public void updateHeader(int ID,String userImg);
}