package com.wangziqing.goubige.mybatis.daoBase;

import com.wangziqing.goubige.model.PageBean;
import com.wangziqing.goubige.model.Share;

import java.util.List;

/**
 * Created by WZQ_PC on 2016/5/16 0016.
 */
public interface ShareOperation {
    public void insert(Share share);
    public void update(Share share);
    public List<Share> getShareByPage(int pageSize,int startRow,int requestUserID);
    public List<Share> getShareUser(int pageSize,int startRow,int requestUserID,int userID);
    public Share getShareByID(int ID);
    public void supportNumIncrease(int ID);
    public void commentNumIncrease(int ID);
}
