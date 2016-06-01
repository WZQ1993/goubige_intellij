package com.wangziqing.goubige.mybatis.daoBase;

import com.wangziqing.goubige.model.PageBean;
import com.wangziqing.goubige.model.Users;

import java.util.List;

public interface UsersOperation {
	public void insert(Users user);
	public void update(Users user);
	public Users getByID(int ID);
	public Integer getIDByPhoneAndEmail(String telePhone,String email);
	public Users getByPhoneAndEmail(String telePhone,String email,String passWord);
	public void updateHeader(int ID,String userImg);
	public List<Users> getUsersByPage(PageBean pageBean);
	public List<Users> getFans(int startRow,int pageSize,int userID);
	public List<Users> getFollows(int startRow,int pageSize,int userID);
	public Integer askUserIsExist(String phone,String email);
	public void addOrUpdate(Users user);
}
