package com.wangziqing.goubige.magic.pipeline;

import com.google.common.collect.Lists;
import com.wangziqing.goubige.model.Category;
import com.wangziqing.goubige.model.Good;
import com.wangziqing.goubige.model.Goods;
import com.wangziqing.goubige.model.Mall;
import com.wangziqing.goubige.mybatis.daoBase.DaoFactory;
import com.wangziqing.goubige.mybatis.daoImp.CategoryDaoImp;
import com.wangziqing.goubige.mybatis.daoImp.GoodDaoImp;
import com.wangziqing.goubige.mybatis.daoImp.GoodsDaoImp;
import com.wangziqing.goubige.mybatis.daoImp.MallDaoImp;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

public class SmzdmPipeline implements Pipeline {
	MallDaoImp mallDaoImp=DaoFactory.getMallDaoImp();
	CategoryDaoImp categoryDaoImp=DaoFactory.getCategoryDaoImp();
	GoodsDaoImp goodDaoImp=DaoFactory.getGoodDaoImp();
	@Override
	public void process(ResultItems resultItems, Task task) {
		// TODO Auto-generated method stub
//		List<Category> CategoryList=resultItems.get("CategoryList");
//		System.out.println(CategoryList.size());
//		categoryDaoImp.insertAll(CategoryList);
//		List<Mall> MallList=resultItems.get("MallList");
//		System.out.println(MallList.size());
//		for (Mall mall:MallList
//			 ) {
//			System.out.println(mall.toString());
//		}
//		mallDaoImp.insertAll(MallList);
		List<Goods> list=resultItems.get("goodList");
		goodDaoImp.addGoods(list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
