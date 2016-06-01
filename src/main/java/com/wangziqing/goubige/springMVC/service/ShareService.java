package com.wangziqing.goubige.springMVC.service;

import com.wangziqing.goubige.model.Share;
import com.wangziqing.goubige.mybatis.daoImp.ShareDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WZQ_PC on 2016/5/16 0016.
 */
@Service
public class ShareService {
    private static final String TAG="ShareService";
    @Autowired
    private ShareDaoImp shareDaoImp;
    public void insert(Share share){
       shareDaoImp.insert(share);
    }
    public void update(Share share){
        shareDaoImp.update(share);
    }
    public Share getShareByID(int ID,Integer userID){
        return shareDaoImp.getShareByID(ID,userID);
    }
    public List<Share> getShareByPage(int pageSize,int pageNum,int requestUserID){
        return shareDaoImp.getShareByPage(pageSize,pageNum,requestUserID);
    }
    public List<Share> getShareByUser(int pageSize,int pageNum,int requestUserID,int userID){
        return shareDaoImp.getShareByUser(pageSize,pageNum,requestUserID,userID);
    }
    public void supportNumIncrease(int ID){
        shareDaoImp.supportNumIncrease(ID);
    }
    public void commentNumIncrease(int ID){
        shareDaoImp.commentNumIncrease(ID);
    }
}
