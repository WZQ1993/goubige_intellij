package com.wangziqing.goubige.springMVC.service;

import java.io.File;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangziqing.goubige.model.Users;
import com.wangziqing.goubige.mybatis.daoImp.UserDaoImp;
import com.wangziqing.goubige.springMVC.utils.FilesUtils;
import com.wangziqing.goubige.springMVC.utils.ProjectString;

@Service
public class UsersService {
	private static final String TAG="UsersService";
	@Autowired
	UserDaoImp userDaoImp;
	public void register(Users user){
		userDaoImp.insert(user);
	}
	public void update(Users user){
		userDaoImp.update(user);
	}
	public Integer getIDByPhoneAndEmail(String telePhone,String email){
		return userDaoImp.getIDByPhoneAndEmail(telePhone, email);
	}
	public Users getByPhoneAndEmail(String telePhone,String email,String passWord){
		return userDaoImp.getByPhoneAndEmail(telePhone, email,passWord);
	}
	public boolean updateheader(InputStream file,int ID){
		return FilesUtils.getFileutils()
		.saveFile(file, ID+".png",FilesUtils.getImageDir())
		&&userDaoImp.updateHeader(ID,"/images/"+ID+".png");
	}
	public Users getByID(int ID){
		return userDaoImp.getByID(ID);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
