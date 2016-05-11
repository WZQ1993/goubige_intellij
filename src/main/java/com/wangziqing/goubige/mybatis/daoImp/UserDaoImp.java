package com.wangziqing.goubige.mybatis.daoImp;


import com.wangziqing.goubige.model.PageBean;
import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangziqing.goubige.model.Users;
import com.wangziqing.goubige.mybatis.daoBase.MySessionFactoryUtil;
import com.wangziqing.goubige.mybatis.daoBase.UsersOperation;

import java.util.List;

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
	public List<Users> getUsersByPage(int pageSize, int pageNum){
		SqlSession session = MySessionFactoryUtil.getSession();
		int startRow=(pageNum-1)*pageSize;
		try {
			UsersOperation usersOperations=session.getMapper(UsersOperation.class);
			return usersOperations.getUsersByPage(new PageBean(startRow,pageSize));
		} finally {
			session.close();
		}
	}
	public void test(){
		String testString="{'method':'authorizations'}";
		JSONObject jsonObject = JSON.parseObject(testString);
		jsonObject.put("user", new Users());
        System.out.println(jsonObject.get("user")instanceof Users);
	}
	public void testAdd(){
		boolean man=true;
		UserDaoImp userDaoImp=new UserDaoImp();
		for(int i=0;i<100;i++){
			Users user=new Users();
			user.setAge((byte)21);
			if(man)user.setGender((byte)1);
			else user.setGender((byte)0);
			user.setUserName("用户"+i);
			user.setRealName("真名"+i);
			user.setPassWord("25f9e794323b453885f5181f1b624d0b");
			user.setUserImg("50.png");
			if(man){
				user.setInfo("这是一段很有意思的个人简介，大家好，我是煞笔-"+i);
				man=false;
			}else {
				user.setInfo("This is a very interesting profile, everybody is good, I am an idiot___"+i);
				man=true;
			}
			user.setIsDelete((byte)0);

			userDaoImp.insert(user);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDaoImp userDaoImp=new UserDaoImp();
		for (Users user:userDaoImp.getUsersByPage(10,2)
			 ) {
			System.out.println(user.getID());
		}
	}
}
