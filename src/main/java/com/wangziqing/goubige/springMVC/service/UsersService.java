package com.wangziqing.goubige.springMVC.service;

import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangziqing.goubige.model.Users;
import com.wangziqing.goubige.mybatis.daoImp.UserDaoImp;
import com.wangziqing.goubige.springMVC.utils.FilesUtils;

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
		&&userDaoImp.updateHeader(ID,ID+".png");
	}
	public Users getByID(int ID){
		return userDaoImp.getByID(ID);
	}
	public List<Users> getUserByPage(int pageSize, int pageNum){
		return userDaoImp.getUsersByPage(pageSize,pageNum);
	}
	public List<Users> getFans(int pageSize, int pageNum,int userID){
		return userDaoImp.getFans(pageSize,pageNum,userID);
	}
	public List<Users> getFollows(int pageSize, int pageNum, int userID){
		return userDaoImp.getFollows(pageSize,pageNum,userID);
	}
	public int askUserIsExist(String phone,String email){
		return userDaoImp.askUserIsExist(phone,email);
	}
	public void addOrUpdate(Users user){
		userDaoImp.addOrUpdate(user);
		if(user.getID()==0){
			user.setID(userDaoImp.askUserIsExist(user.getTelePhone(),user.getEmail()));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
