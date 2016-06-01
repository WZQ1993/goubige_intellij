package com.wangziqing.goubige.mybatis.daoImp;

import com.wangziqing.goubige.model.PageBean;
import com.wangziqing.goubige.model.Score;
import com.wangziqing.goubige.model.Share;
import com.wangziqing.goubige.mybatis.daoBase.GoodOperation;
import com.wangziqing.goubige.mybatis.daoBase.MySessionFactoryUtil;
import com.wangziqing.goubige.mybatis.daoBase.ShareOperation;
import com.wangziqing.goubige.mybatis.daoBase.SupportOperation;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WZQ_PC on 2016/5/16 0016.
 */
@Repository
public class ShareDaoImp {
    public void insert(Share share){
        SqlSession session = MySessionFactoryUtil.getSession();
        try {
            ShareOperation shareOperation=session.getMapper(ShareOperation.class);
            GoodOperation goodOperation=session.getMapper(GoodOperation.class);
            Score score=new Score();
            score.setUserID(share.getUserID());
            score.setCategoryID(goodOperation.getCategoryID(share.getGoodID()));
            score.setScore(2);
            goodOperation.addAndUpdateScore(score);
            shareOperation.insert(share);
            session.commit();
        } finally {
            session.close();
        }
    }
    public void update(Share share){
        SqlSession session = MySessionFactoryUtil.getSession();
        try {
            ShareOperation shareOperation=session.getMapper(ShareOperation.class);
            shareOperation.update(share);
            session.commit();
        } finally {
            session.close();
        }
    }
    public Share getShareByID(int ID,Integer userID){
        SqlSession session = MySessionFactoryUtil.getSession();
        try {
            ShareOperation shareOperation=session.getMapper(ShareOperation.class);
            SupportOperation supportOperation=session.getMapper(SupportOperation.class);
            Share share=shareOperation.getShareByID(ID);
            if(null!=userID){
                if(supportOperation.isSupport(ID,userID)>0){
                    share.setSupported(true);
                }else share.setSupported(false);
            }
            return share;
        } finally {
            session.close();
        }
    }
    public List<Share> getShareByPage(int pageSize, int pageNum,int requestUserID){
        SqlSession session = MySessionFactoryUtil.getSession();
        int startRow=(pageNum-1)*pageSize;
        try {
            ShareOperation shareOperation=session.getMapper(ShareOperation.class);
            return shareOperation.getShareByPage(pageSize,startRow,requestUserID);
        } finally {
            session.close();
        }
    }
    public List<Share> getShareByUser(int pageSize, int pageNum,int requestUserID,int userID){
        SqlSession session = MySessionFactoryUtil.getSession();
        int startRow=(pageNum-1)*pageSize;
        try {
            ShareOperation shareOperation=session.getMapper(ShareOperation.class);
            return shareOperation.getShareUser(pageSize,startRow,requestUserID,userID);
        } finally {
            session.close();
        }
    }
    public void supportNumIncrease(int ID){
        SqlSession session = MySessionFactoryUtil.getSession();
        try {
            ShareOperation shareOperation=session.getMapper(ShareOperation.class);
            shareOperation.supportNumIncrease(ID);
            session.commit();
        } finally {
            session.close();
        }
    }
    public void commentNumIncrease(int ID){
        SqlSession session = MySessionFactoryUtil.getSession();
        try {
            ShareOperation shareOperation=session.getMapper(ShareOperation.class);
            shareOperation.commentNumIncrease(ID);
            session.commit();
        } finally {
            session.close();
        }
    }
    private static void testInsert(){
        ShareDaoImp shareDaoImp=new ShareDaoImp();
        for(int i=0;i<100;i++){
            Share share=new Share();
            share.setGoodID(18960);
            share.setUserID(151);
            share.setContent("推荐内容"+i+"：强烈推荐这个商品强烈推荐这个商品强烈推荐这个商品强烈推荐这个商品强烈推荐这个商品");
            shareDaoImp.insert(share);
        }
    }
    private static void testUpdate(){
        ShareDaoImp shareDaoImp=new ShareDaoImp();
        Share share=new Share();
        share.setID(204);
        share.setGoodID(18960);
        share.setUserID(151);
        share.setContent("推荐内容1：强烈推荐这个商品!!!");
        shareDaoImp.update(share);
    }
    private static void testGetByID(){
        ShareDaoImp shareDaoImp=new ShareDaoImp();
        System.out.println(shareDaoImp.getShareByID(204,151).toString());
    }
    private static void testGetByPage(){
        ShareDaoImp shareDaoImp=new ShareDaoImp();
        for (Share share:shareDaoImp.getShareByPage(10,1,151)
             ) {
            System.out.println(share.getID()+"-"+share.isSupported());
        }
    }
    private static void testIncrease(){
        ShareDaoImp shareDaoImp=new ShareDaoImp();
        shareDaoImp.supportNumIncrease(204);
        shareDaoImp.commentNumIncrease(204);
    }
    public static void main(String[] args){
        testGetByPage();
    }
}
