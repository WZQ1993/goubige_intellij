package com.wangziqing.goubige.mybatis.daoImp;

import com.wangziqing.goubige.model.Comment;
import com.wangziqing.goubige.model.PageBean;
import com.wangziqing.goubige.model.Share;
import com.wangziqing.goubige.mybatis.daoBase.CommentOperation;
import com.wangziqing.goubige.mybatis.daoBase.MySessionFactoryUtil;
import com.wangziqing.goubige.mybatis.daoBase.ShareOperation;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WZQ_PC on 2016/5/16 0016.
 */
@Repository
public class CommentDaoImp {
    public void insert(Comment comment){
        SqlSession session = MySessionFactoryUtil.getSession();
        try {
            CommentOperation commentOperation=session.getMapper(CommentOperation.class);
            commentOperation.insert(comment);
            session.commit();
        } finally {
            session.close();
        }
    }

    public List<Comment> getCommentByPage(int pageSize, int pageNum,int shareID){
        SqlSession session = MySessionFactoryUtil.getSession();
        int startRow=(pageNum-1)*pageSize;
        try {
            CommentOperation commentOperation=session.getMapper(CommentOperation.class);
            return commentOperation.getCommentByPage(startRow,pageSize,shareID);
        } finally {
            session.close();
        }
    }

    private static void testInsert(){
        CommentDaoImp commentDaoImp=new CommentDaoImp();
        for(int i=0;i<100;i++){
            Comment comment=new Comment();
            comment.setUserID(151);
            comment.setShareID(104);
            comment.setContent("评论内容"+i+"：强烈推荐这个商品");
            commentDaoImp.insert(comment);
        }
    }

    private static void testGetByPage(){
        CommentDaoImp commentDaoImp=new CommentDaoImp();
        for (Comment comment:commentDaoImp.getCommentByPage(10,2,104)
             ) {
            System.out.println(comment.getID());
        }
    }

    public static void main(String[] args){
        testInsert();
        testGetByPage();
    }
}
