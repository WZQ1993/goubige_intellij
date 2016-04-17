package com.wangziqing.goubige.model;

import java.sql.Timestamp;

/**
    * brands 实体类
    * Mon Jan 18 14:35:14 CST 2016 王梓青
    */ 


public class Brand{
	private int ID;
	private String title;
	private String url;
	private String name;
	private Timestamp creatTime;
	public void setID(int ID){
	this.ID=ID;
	}
	public int getID(){
		return ID;
	}
	public void setTitle(String title){
	this.title=title;
	}
	public String getTitle(){
		return title;
	}
	public void setUrl(String url){
	this.url=url;
	}
	public String getUrl(){
		return url;
	}
	public void setName(String name){
	this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setCreatTime(Timestamp creatTime){
	this.creatTime=creatTime;
	}
	public Timestamp getCreatTime(){
		return creatTime;
	}
}

