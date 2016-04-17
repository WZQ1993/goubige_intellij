package com.wangziqing.goubige.magic.processor;
import java.util.List;

import com.wangziqing.goubige.magic.util.MyStringUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

public class JuanPiProcessor implements PageProcessor {
	public static final String URL_CALLSIFY="http://www\\.juanpi\\.com/\\w+$";
	//http://shop.juanpi.com/deal/4132096
	public static final String URL_ITEM="http://shop\\.juanpi\\.com/deal/\\d+$";
	public static final String URL_LIST="http://www\\.juanpi\\.com/?$";
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
		if(page.getUrl().regex(URL_LIST).match()){
			page.addTargetRequests(
					page.getHtml().xpath("//div[@class=\"banner_l\"]").links().regex(URL_CALLSIFY).all());
			
		}
		//对每一个分类,19.9包邮
		else if(page.getUrl().regex(URL_CALLSIFY).match()){
			String sort=MyStringUtil.getSplitString(page.getUrl().toString(),"/",3);
			System.out.println(sort);
			List<String> list= page.getHtml().xpath("//ul[@class=\"goods-list clear\"]").css("li").all();
			String 	
				goodID=null,
				goodUrl=null,
				goodPic=null,
				goodTitle=null,
				goodSold=null,
				goodPriceCurrent=null,
				goodPriceOld=null,
				goodDiscount=null,
				goodFrom=null,
				goodSort=sort;
			for (String htmlString : list) {
				Html html=new Html(htmlString);
				goodUrl=html.links().regex(URL_ITEM).get();
				page.putField("goodUrl", goodUrl);
				goodID=goodUrl.hashCode()+"";
				page.putField("goodID", goodID);
				goodPic=html.xpath("//div[@class=\"good-pic\"]")
						.xpath("//img/@d-src").get();
				page.putField("goodPic", goodPic);
				goodTitle=html.xpath("//h3[@class=\"good-title\"]").xpath("//a/text()").get();
				page.putField("goodTitle", goodTitle);
				goodSold=html.xpath("//h3[@class=\"good-title\"]").xpath("//span[@class=\"sold\"]/text()").get();
				page.putField("goodSold", goodSold);
				
				goodPriceCurrent=html.xpath("//span[@class=\"price-current\"]/text()").get();
				page.putField("goodPriceCurrent", goodPriceCurrent);
				
				goodPriceOld=html.xpath("//span[@class=\"price-old\"]/text()").get();
				page.putField("goodPriceOld", goodPriceOld);
				
				goodDiscount=html.xpath("//span[@class=\"discount\"]").xpath("//em/text()").get();
				page.putField("goodDiscount", goodDiscount);
				
				goodFrom=html.xpath("//div[@class=\"good-price\"]").xpath("//a").xpath("//span/text()").get();
				if(goodFrom.equals("特卖"))goodFrom="卷皮";
				page.putField("goodFrom", goodFrom);
				page.putField("goodSort", goodSort);
//				System.out.println(goodID+"======"+
//						goodUrl+"======"+
//						goodPic+"======"+
//						goodTitle+"======"+
//						goodSold+"======"+
//						goodPriceCurrent+"======"+
//						goodPriceOld+"======"+
//						goodDiscount+"======"+
//						goodFrom+"======"+
//						goodSort+"======"
//						);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spider.create(new JuanPiProcessor()).addUrl("http://www.juanpi.com/")
			.addPipeline(new Pipeline() {
				
				@Override
				public void process(ResultItems resultItems, Task task) {
					// TODO Auto-generated method stub
					
				}
			})
			.thread(5).start();
//		System.out.println("http://www.jiukuaiyou.com/click/?id=76682511".matches(URL_ITEM));
	}

}
