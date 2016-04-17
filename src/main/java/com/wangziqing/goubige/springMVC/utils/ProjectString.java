package com.wangziqing.goubige.springMVC.utils;

public enum ProjectString {
	IMAGE("image");
	private static String HOST="http://192.168.1.20:8080/goubige";
	private String resourseName;
	private ProjectString(String resourseName) {
		// TODO Auto-generated constructor stub
		this.resourseName=resourseName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return HOST+"/WEB-INF/resourse/"+resourseName;
	}
	
}
