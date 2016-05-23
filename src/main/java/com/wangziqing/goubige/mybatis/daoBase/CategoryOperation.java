package com.wangziqing.goubige.mybatis.daoBase;

import com.wangziqing.goubige.model.Category;

import java.util.List;

/**
 * Created by WZQ_PC on 2016/5/23 0023.
 */
public interface CategoryOperation {
    public void insert (Category category);
    public List<Category> getCategorys();
}
