package com.wangziqing.goubige.mybatis.daoImp;

import com.wangziqing.goubige.model.Fans;
import com.wangziqing.goubige.model.Support;
import com.wangziqing.goubige.mybatis.daoBase.FansOperation;
import com.wangziqing.goubige.mybatis.daoBase.MySessionFactoryUtil;
import com.wangziqing.goubige.mybatis.daoBase.ShareOperation;
import com.wangziqing.goubige.mybatis.daoBase.SupportOperation;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Created by WZQ_PC on 2016/5/16 0016.
 */
@Repository
public class FansDaoImp {
    public void insert(Fans fans){
        SqlSession session = MySessionFactoryUtil.getSession();
        try {
            FansOperation fansOperation=session.getMapper(FansOperation.class);
            fansOperation.insert(fans);
            session.commit();
        } finally {
            session.close();
        }
    }
    public boolean isFans(int userID,int fansID){
        SqlSession session = MySessionFactoryUtil.getSession();
        try {
            FansOperation fansOperation=session.getMapper(FansOperation.class);
            if(fansOperation.isFans(userID,fansID)>0)
                return true;
            else return false;
        } finally {
            session.close();
        }
    }

}
