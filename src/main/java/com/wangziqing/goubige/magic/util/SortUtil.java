package com.wangziqing.goubige.magic.util;

import java.util.HashMap;
import java.util.Map;

public class SortUtil {
	private static  Map<String,String> sortMap=null;
	private SortUtil(){
		
	}
	public static Map<String,String> getInstance(){
		if(sortMap==null){
			sortMap=new HashMap<>();
			sortMap.put("901", "时尚女装");
			sortMap.put("902", "舒适内衣");
			sortMap.put("903", "抱抱配饰");
			sortMap.put("904", "女装");
			sortMap.put("905", "女装");
			sortMap.put("906", "女装");
			sortMap.put("907", "女装");
			sortMap.put("908", "女装");
			sortMap.put("909", "女装");
			sortMap.put("910", "女装");
			sortMap.put("911", "女装");
		}
		return sortMap;
	}
	
}
