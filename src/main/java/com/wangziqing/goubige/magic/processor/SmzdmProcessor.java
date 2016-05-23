package com.wangziqing.goubige.magic.processor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.wangziqing.goubige.magic.pipeline.SmzdmPipeline;
import com.wangziqing.goubige.magic.util.DateUtils;
import com.wangziqing.goubige.magic.util.PatternUtils;
import com.wangziqing.goubige.model.Category;
import com.wangziqing.goubige.model.Goods;
import com.wangziqing.goubige.model.Mall;
import com.wangziqing.goubige.mybatis.daoBase.DaoFactory;
import com.wangziqing.goubige.mybatis.daoImp.CategoryDaoImp;
import us.codecraft.webmagic.*;
import us.codecraft.webmagic.processor.PageProcessor;

import java.sql.Timestamp;
import java.util.List;

public class SmzdmProcessor implements PageProcessor {
	public static final String URL_SEARCH="http://api\\.smzdm\\.com/v1/filter/search$";
	public static final String URL_LIST="http://api\\.smzdm\\.com/v1/youhui/articles/?";
	public static List<String> urls=Lists.newArrayList();
	private static int index=0;
	//爬虫配置
	 private Site site = Site
	            .me()
	            .setSleepTime(3000)
	            .setUserAgent(
	                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

	@Override
	public void process(Page page) {
		// TODO Auto-generated method stub
		//主页面-将分类的url添加

		if(page.getUrl().regex(URL_SEARCH).match()){
			List<Mall> guoneiMall,haiwaiMall;
			List<Category> categoryList;
			String jsonString =page.getRawText();
			JSONObject jsonObject=JSON.parseObject(jsonString);
			JSONObject data=jsonObject.getJSONObject("data");
			JSONObject mall=data.getJSONObject("mall");
			guoneiMall=
					JSON.parseArray(mall.getString("guonei"),Mall.class);
			haiwaiMall=
					JSON.parseArray(mall.getString("haiwai"),Mall.class);
			categoryList=
					JSON.parseArray(data.getString("category"),Category.class);
			guoneiMall.addAll(haiwaiMall);
			page.putField("CategoryList", categoryList);
			page.putField("MallList",guoneiMall);
		}else if(page.getUrl().regex(URL_LIST).match()){
			System.out.println(page.getUrl().toString());
			int categoryID= PatternUtils.getCategoryFromUrl(page.getUrl().toString());
			if(index==0){
				urls.remove(0);
				page.addTargetRequests(urls);
				index=1;
			}
			String jsonString =page.getRawText();
			JSONObject jsonObject=JSON.parseObject(jsonString);
			JSONObject data=jsonObject.getJSONObject("data");
			JSONArray rows=data.getJSONArray("rows");
			List<Goods> list=Lists.newArrayList();
			for(int i=0;i<rows.size();i++){
				JSONObject object=rows.getJSONObject(i);
				Goods good=new Goods();
				good.setTitle(object.getString("article_title"));
				good.setUrl(object.getString("article_link"));
				good.setPic(object.getString("article_pic"));
				good.setPrice(object.getString("article_price"));
				good.setMall(object.getString("article_mall"));
				good.setDate(Timestamp.valueOf(object.getString("article_date")));
				good.setCategoryID(categoryID);
				list.add(good);
			}
			page.putField("goodList",list);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String BaseUrl="http://api.smzdm.com/v1/youhui/articles/?";
		CategoryDaoImp categoryDaoImp= DaoFactory.getCategoryDaoImp();
		String url="";
		List<Category> categories=categoryDaoImp.getCategorys();
		for (Category category:categories) {
			String now = DateUtils.getNow();
			for(int i=0;i<30;i++){
				url=BaseUrl+"category="+category.getID()+"&article_date="+now;
				now = DateUtils.getPreDate(now);
				urls.add(url);
			}
		}
		System.out.print(urls.size());
		Spider.create(new SmzdmProcessor())
				.addUrl(urls.get(0))
				.addPipeline(new SmzdmPipeline())
				.thread(5)
				.start();
	}

}
