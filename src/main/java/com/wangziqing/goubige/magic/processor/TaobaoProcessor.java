package com.wangziqing.goubige.magic.processor;
import java.util.ArrayList;
import java.util.List;

import com.wangziqing.goubige.magic.pipeline.MybatisPipeline;
import com.wangziqing.goubige.model.Good;
import com.wangziqing.goubige.mybatis.daoImp.GoodDaoImp;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

public class TaobaoProcessor implements PageProcessor {
	//示例：http://zhi.taobao.com/json/fantomasItems.htm?appId=9&blockId=901&pageSize=100&startRow=0&extQuery=tagId%3A1072001
	public static final String URL_CALLSIFY="https?://zhi\\.taobao\\.com/json/fantomasItems\\.htm\\?"
			+ "appId=\\d+&blockId=\\d+&pageSize=\\d+&startRow=\\d+$";
	public static final String URL_ITEM="https?://item\\.taobao\\.com/item\\.htm\\?"
			+ "(spm=.*&)?id=\\d+$";
	public static final String URL_LIST="https?://tejia\\.taobao\\.com/?$";
	
	public static final String URL_start="https://item.taobao.com/item.htm?id=";

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
		List<String> Urls=new ArrayList<>();
		if(page.getUrl().regex(URL_LIST).match()){
			List<String> list= page.getHtml()
					.xpath("//ul[@class=\"tj_cats_list\"]")
					.xpath("//a/@data-cat-id").all();
			for (String blockID : list) {
				//914为全部商品
				if(blockID.equals("914"))continue;
				Urls.add(creatURLByBlockID(blockID,100,0));
//				switch (blockID) {
//				case "901":
//					nvZhuang [] Array_901=Sort.nvZhuang.values();
//					for (nvZhuang n : Array_901) {
////						System.out.println(n.getBlockID()+"______"+n.getTagID());
//						Urls.add(creatURLByTagID(n.getBlockID(), n.getTagID(),100,0));
//					}
//					break;
//				case "902":
//					neiYi [] Array_902=Sort.neiYi.values();
//					for (neiYi n : Array_902) {
////						System.out.println(n.getBlockID()+"______"+n.getTagID());
//						Urls.add(creatURLByTagID(n.getBlockID(), n.getTagID(),100,0));
//					}
//					break;
//				case "903":
//					baoBaoPetShi [] Array_903=Sort.baoBaoPetShi.values();
//					for (baoBaoPetShi n : Array_903) {
////						System.out.println(n.getBlockID()+"______"+n.getTagID());
//						Urls.add(creatURLByTagID(n.getBlockID(), n.getTagID(),100,0));
//					}
//					break;
//				case "904":
//					nanXieNvXie [] Array_904=Sort.nanXieNvXie.values();
//					for (nanXieNvXie n : Array_904) {
////						System.out.println(n.getBlockID()+"______"+n.getTagID());
//						Urls.add(creatURLByTagID(n.getBlockID(), n.getTagID(),100,0));
//					}
//					break;
//				case "905":
//					nanZhuang [] Array_905=Sort.nanZhuang.values();
//					for (nanZhuang n : Array_905) {
////						System.out.println(n.getBlockID()+"______"+n.getTagID());
//						Urls.add(creatURLByTagID(n.getBlockID(), n.getTagID(),100,0));
//					}
//					break;
//				case "906":
//					youEr [] Array_906=Sort.youEr.values();
//					for (youEr n : Array_906) {
////						System.out.println(n.getBlockID()+"______"+n.getTagID());
//						Urls.add(creatURLByTagID(n.getBlockID(), n.getTagID(),100,0));
//					}
//					break;
//				case "907":
//					riYongBaiHuo [] Array_907=Sort.riYongBaiHuo.values();
//					for (riYongBaiHuo n : Array_907) {
////						System.out.println(n.getBlockID()+"______"+n.getTagID());
//						Urls.add(creatURLByTagID(n.getBlockID(), n.getTagID(),100,0));
//					}
//					break;
//				case "908":
//					meiShiTeChan [] Array_908=Sort.meiShiTeChan.values();
//					for (meiShiTeChan n : Array_908) {
////						System.out.println(n.getBlockID()+"______"+n.getTagID());
//						Urls.add(creatURLByTagID(n.getBlockID(), n.getTagID(),100,0));
//					}
//					break;
//				case "909":
//					shuMaJiaDian [] Array_909=Sort.shuMaJiaDian.values();
//					for (shuMaJiaDian n : Array_909) {
////						System.out.println(n.getBlockID()+"______"+n.getTagID());
//						Urls.add(creatURLByTagID(n.getBlockID(), n.getTagID(),100,0));
//					}
//					break;
//				case "910":
//					meiRongHuFu [] Array_910=Sort.meiRongHuFu.values();
//					for (meiRongHuFu n : Array_910) {
////						System.out.println(n.getBlockID()+"______"+n.getTagID());
//						Urls.add(creatURLByTagID(n.getBlockID(), n.getTagID(),100,0));
//					}
//					break;
//				case "911":
//					chePinHuWai [] Array_911=Sort.chePinHuWai.values();
//					for (chePinHuWai n : Array_911) {
////						System.out.println(n.getBlockID()+"______"+n.getTagID());
//						Urls.add(creatURLByTagID(n.getBlockID(), n.getTagID(),100,0));
//					}
//					break;
//				default:
//					break;
//				}	
			}
			page.addTargetRequests(Urls);
		}
		//使用jsonpath语言解析数据
		else if(page.getUrl().regex(URL_CALLSIFY).match()){
			//PS:对字符串进行操作时注意考虑空格的影响
			int totalItem=0,pageSize=0,startRow=0;
			String blockId=null;
			StringBuilder imgPrefix=new StringBuilder("http:");
			String jsonString=page.getRawText().trim();
			jsonString=jsonString.substring(1, jsonString.length()-1);
			Json goodListJson=new  Json(jsonString);
			Json goodItemJson=null;
			totalItem=Integer.parseInt(goodListJson.jsonPath("$.totalItem").get());
			pageSize=Integer.parseInt(goodListJson.jsonPath("$.pageSize").get());
			startRow=Integer.parseInt(goodListJson.jsonPath("$.startRow").get())+1;
			blockId=goodListJson.jsonPath("$.blockId").get();
			imgPrefix.append(goodListJson.jsonPath("$.picServer").get()).append("/");
			if(totalItem>pageSize*startRow){
				//数据未完全取出
				page.addTargetRequest(creatURLByBlockID(blockId, 100, startRow));
			}
			List<String> itemJsonStringArray=goodListJson.jsonPath("$.data[*]").all();
			List<Good> goodList=new ArrayList<>();
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
				goodSort=null;
			goodSort=goodListJson.jsonPath("$.blockId").get();
			for (String htmlString :itemJsonStringArray ) {
				Good good=new Good();
				goodItemJson=new Json(htmlString);
				goodUrl=creatURLByItemId(goodItemJson.jsonPath("$.itemId").get());
//				page.putField("goodUrl", goodUrl);
				goodID=goodUrl.hashCode()+"";
//				page.putField("goodID", goodID);
				goodPic=imgPrefix.toString()+goodItemJson.jsonPath("$.activityPicUrl").get();
//				page.putField("goodPic", goodPic);
				goodTitle=goodItemJson.jsonPath("$.title").get();
//				page.putField("goodTitle", goodTitle);
				goodSold=goodItemJson.jsonPath("$.currentSellOut").get();
//				page.putField("goodSold", goodSold);
				
				goodPriceCurrent=goodItemJson.jsonPath("$.discountPrice").get();
//				page.putField("goodPriceCurrent", goodPriceCurrent);
				
				goodPriceOld=goodItemJson.jsonPath("$.reservePrice").get();
//				page.putField("goodPriceOld", goodPriceOld);
				
				goodDiscount=Double.toString(
						((Double.parseDouble(goodItemJson.jsonPath("$.discount").get()))/100));
//				page.putField("goodDiscount", goodDiscount);
				
				goodFrom="淘宝特卖";
//				page.putField("goodFrom", goodFrom);
//				page.putField("goodSort", goodSort);
				good.setID(goodID);
				good.setTitle(goodTitle);
				good.setUrl(goodUrl);
				good.setPic(goodPic);
				good.setSold(Integer.parseInt(goodSold));
				good.setPriceCurrent(Integer.parseInt(goodPriceCurrent));
				good.setPriceOld(Integer.parseInt(goodPriceOld));
				good.setDiscount(Byte.parseByte(goodDiscount));
				good.setFrom(1);
				good.setBlockId(1);
				good.setTagId(1);
				goodList.add(good);
			}
			page.putField("goodList", goodList);
		}

	}
	private String creatURLByTagID(String blockID,String TagID,int pageSize,int startRow){
		StringBuilder URL=new StringBuilder("http://zhi.taobao.com/json/fantomasItems.htm?appId=9");
		//&pageSize=2&startRow=0&extQuery=tagId%3A1204005
		URL.append("&blockId="+blockID)
		.append("&pageSize="+pageSize)
		.append("&startRow="+startRow)
		.append("&extQuery=tagId%3A"+TagID);
		return URL.toString();
	}
	private String creatURLByBlockID(String blockID,int pageSize,int startRow){
		StringBuilder URL=new StringBuilder("http://zhi.taobao.com/json/fantomasItems.htm?appId=9");
		//&pageSize=2&startRow=0&extQuery=tagId%3A1204005
		URL.append("&blockId="+blockID)
		.append("&pageSize="+pageSize)
		.append("&startRow="+startRow);
		return URL.toString();
	}
	private String creatURLByItemId(String itemId){
		return URL_start+itemId;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spider.create(new TaobaoProcessor()).addUrl("http://tejia.taobao.com/")
			.addPipeline(new MybatisPipeline())
			.thread(5).start();
//		System.out.println("http://zhi.taobao.com/json/fantomasItems.htm?appId=9&blockId=901&pageSize=100&startRow=0&extQuery=tagId%3A1072001"
//				.matches(URL_CALLSIFY));
//		String jsonp="({'itemId': '45335996537'})";
//		jsonp=jsonp.substring(1, jsonp.length()-1);
		System.out.println(
//				new JsonPathSelector("$.itemId").select("({'itemId': '45335996537'})")
				);
	}

}
