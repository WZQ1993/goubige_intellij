package com.wangziqing.goubige.springMVC.service;

import com.wangziqing.goubige.model.Comment;
import com.wangziqing.goubige.model.Sort;
import com.wangziqing.goubige.mybatis.daoImp.CommentDaoImp;
import com.wangziqing.goubige.mybatis.daoImp.SortDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
	@Autowired
	CommentDaoImp commentDaoImp;
	public List<Comment> getByPage(int pageSize, int pageNum,int shareID){
		return commentDaoImp.getCommentByPage(pageSize,pageNum,shareID);
	}
	public void insert(Comment comment){
		commentDaoImp.insert(comment);
	}

}
