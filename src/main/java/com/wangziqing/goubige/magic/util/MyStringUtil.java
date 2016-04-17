package com.wangziqing.goubige.magic.util;

import java.io.File;

public class MyStringUtil {
	private MyStringUtil() {
		// TODO Auto-generated constructor stub
	}
	public static	 void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				MyStringUtil.getSplitString("s1.juancdn.com/bao/160112/d/3/569468f592be594c148b4567_400x400.jpg_285x285.jpg", 
				"/", 5)
				);
	}
	/**
	 * 返回Str由regex分解的第index个字符串
	 * @param str
	 * @param regex
	 * @param index
	 * @return
	 */
	public static String getSplitString(String str,String regex,int index){
		String[] str_array=str.split(regex);
		return str_array[index];
	}
}
