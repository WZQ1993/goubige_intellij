package com.wangziqing.goubige.mybatis.daoBase;

import com.wangziqing.goubige.model.Comment;
import com.wangziqing.goubige.model.PageBean;
import com.wangziqing.goubige.model.Sort;

import java.util.List;

public interface CommentOperation {
	public void insert(Comment comment);
	public List<Comment> getCommentByPage(int startRow,int pageSize,int ShareID);

}
