package com.wangziqing.goubige.magic.processor;
import java.util.ArrayList;
import java.util.List;

import com.wangziqing.goubige.magic.util.MyCollections;
import com.wangziqing.goubige.magic.util.MyStringUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

public class JiuKuaiYouProcessor implements PageProcessor {

	public static final String URL_CALLSIFY="http://www\\.jiukuaiyou\\.com/jiu/\\w+$";
	public static final String URL_LIST="http://www\\.jiukuaiyou\\.com/?$";
	public static final String URL_ITEM="http://www\\.jiukuaiyou\\.com/click/\\?id="
			+ "\\d+$";
	public static final String URL_SHIJIU="http://www\\.jiukuaiyou\\.com/shijiu$";
	//详情url+++http://www.jiukuaiyou.com/click/?id=76192621
	//爬虫配置
	 private Site site = Site
	            .me()
	            .setSleepTime(3000)
	            .setUserAgent(
	                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

	public void process(Page page) {
		// TODO Auto-generated method stub
		//9块9主页面-将分类的url,19.9url添加
		if(page.getUrl().regex(URL_LIST).match()){
			page.addTargetRequests(
					page.getHtml().xpath("//div[@class=\"nav\"]").links().regex(URL_CALLSIFY).all());
			page.addTargetRequests(
					page.getHtml().xpath("//div[@class=\"nav\"]").links().regex(URL_SHIJIU).all());
		}
		//对每一个分类,19.9包邮
		else if(page.getUrl().regex(URL_CALLSIFY).match()||page.getUrl().regex(URL_SHIJIU).match()){
			String sort=null;
			if(page.getUrl().regex(URL_CALLSIFY).match())
				sort=MyStringUtil.getSplitString(page.getUrl().toString(),"/",4);
			List<String> list= page.getHtml().xpath("//ul[@class=\"goods-list\"]").css("li").all();
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
				goodPic=html.xpath("//div[@class=\"pic-img\"]").xpath("//img/@src").get();
				page.putField("goodPic", goodPic);
				goodTitle=html.xpath("//h5[@class=\"good-title\"]").xpath("//a[@class=\"title\"]/text()").get();
				page.putField("goodTitle", goodTitle);
				goodSold=html.xpath("//h5[@class=\"good-title\"]").xpath("//span[@class=\"sold\"]/text()").get();
				page.putField("goodSold", goodSold);
				
				goodPriceCurrent=html.xpath("//span[@class=\"price-current\"]/text()").get();
				page.putField("goodPriceCurrent", goodPriceCurrent);
				
				goodPriceOld=html.xpath("//span[@class=\"price-old\"]/text()").get();
				page.putField("goodPriceOld", goodPriceOld);
				
				goodDiscount=html.xpath("//span[@class=\"discount\"]").xpath("//em/text()").get();
				page.putField("goodDiscount", goodDiscount);
				
				goodFrom=html.xpath("//div[@class=\"good-price\"]").xpath("//a").xpath("//span/text()").get();
				page.putField("goodFrom", goodFrom);
				page.putField("goodSort", goodSort);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Spider.create(new JiuKuaiYouProcessor()).addUrl("http://www.jiukuaiyou.com/")
			.addPipeline(new  Pipeline() {
				
				public void process(ResultItems resultItems, Task task) {
					// TODO Auto-generated method stub
					
				}
			})
			.thread(5).start();
//		System.out.println("http://www.jiukuaiyou.com/click/?id=76682511".matches(URL_ITEM));
	}

}
