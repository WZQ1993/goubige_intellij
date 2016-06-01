package com.wangziqing.goubige.mybatis.daoImp;

import com.wangziqing.goubige.model.Support;
import com.wangziqing.goubige.mybatis.daoBase.MySessionFactoryUtil;
import com.wangziqing.goubige.mybatis.daoBase.ShareOperation;
import com.wangziqing.goubige.mybatis.daoBase.SupportOperation;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Created by WZQ_PC on 2016/5/16 0016.
 */
@Repository
public class SupportDaoImp {
    public void insert(Support support){
        SqlSession session = MySessionFactoryUtil.getSession();
        try {
            SupportOperation supportOperation=session.getMapper(SupportOperation.class);
            ShareOperation shareOperation=session.getMapper(ShareOperation.class);
            supportOperation.insert(support);
            shareOperation.supportNumIncrease(support.getShareID());
            session.commit();
        } finally {
            session.close();
        }
    }

    private static void testInsert(){
        Support support=new Support();
        support.setShareID(204);
        support.setUserID(151);
        new SupportDaoImp().insert(support);
    }

    public static void main(String[] args){
        testInsert();
    }
}
