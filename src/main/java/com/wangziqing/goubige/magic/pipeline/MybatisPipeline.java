package com.wangziqing.goubige.magic.pipeline;

import java.util.List;

import com.wangziqing.goubige.model.Good;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class MybatisPipeline implements Pipeline {
//	GoodDaoImp dao=DaoFactory.getGoodDaoInstance();

	@Override
	public void process(ResultItems resultItems, Task task) {
		// TODO Auto-generated method stub
		List<Good> goodList=resultItems.get("goodList");
//		dao.addGoods(goodList);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
