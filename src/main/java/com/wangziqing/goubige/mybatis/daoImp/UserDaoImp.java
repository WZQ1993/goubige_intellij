package com.wangziqing.goubige.mybatis.daoImp;


import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangziqing.goubige.model.Users;
import com.wangziqing.goubige.mybatis.daoBase.MySessionFactoryUtil;
import com.wangziqing.goubige.mybatis.daoBase.UsersOperation;

@Repository
public class UserDaoImp {
	
	public void insert(Users user){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			UsersOperation usersOperations=session.getMapper(UsersOperation.class);
			usersOperations.insert(user);
			session.commit();
		} finally {
			session.close();
		}
	}
	public void update(Users user){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			UsersOperation usersOperations=session.getMapper(UsersOperation.class);
			usersOperations.update(user);
			session.commit();
		} finally {
			session.close();
		}
	}
	public Users getByID(int ID){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			UsersOperation usersOperations=session.getMapper(UsersOperation.class);
			return usersOperations.getByID(ID);
		} finally {
			session.close();
		}
	}
	public Integer getIDByPhoneAndEmail(String telePhone,String email){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			UsersOperation usersOperations=session.getMapper(UsersOperation.class);
			return usersOperations.getIDByPhoneAndEmail(telePhone,email);
		} finally {
			session.close();
		}
	}
	public Users getByPhoneAndEmail(String telePhone,String email,String passWord){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			UsersOperation usersOperations=session.getMapper(UsersOperation.class);
			return usersOperations.getByPhoneAndEmail(telePhone,email,passWord);
		} finally {
			session.close();
		}
	}
	public boolean updateHeader(int ID,String userImg){
		SqlSession session = MySessionFactoryUtil.getSession();
		try {
			UsersOperation usersOperations=session.getMapper(UsersOperation.class);
			usersOperations.updateHeader(ID, userImg);
			session.commit();
		}catch(Exception e){
			return false;
		}
		finally {
			session.close();
		}
		return true;
	}

	public void test(){
		String testString="{'method':'authorizations'}";
		JSONObject jsonObject = JSON.parseObject(testString);
		jsonObject.put("user", new Users());
        System.out.println(jsonObject.get("user")instanceof Users);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDaoImp userDaoImp=new UserDaoImp();
//		Users user=userDaoImp.getByID(5);
//		user.setUserName("梓青");
//		userDaoImp.update(user);
//		userDaoImp.updateHeader(39, "test1");
//		Users users=userDaoImp
//				.getByPhoneAndEmail("13570240744", "", "e807f1fcf82d132f9bb018ca6738a19f");
//		System.out.println(users==null);
//		System.out.println(userDaoImp.getIDByPhoneAndEmail("13570240144", ""));
//		userDaoImp.test();
	}

}
