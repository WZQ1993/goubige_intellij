package com.wangziqing.goubige.springMVC.service;

import com.wangziqing.goubige.model.Category;
import com.wangziqing.goubige.model.Share;
import com.wangziqing.goubige.mybatis.daoImp.CategoryDaoImp;
import com.wangziqing.goubige.mybatis.daoImp.ShareDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WZQ_PC on 2016/5/16 0016.
 */
@Service
public class CategoryService {
    private static final String TAG="CategoryService";
    @Autowired
    private CategoryDaoImp categoryDaoImp;
    public List<Category> getCategorys(){
        return categoryDaoImp.getCategorys();
    }
}
