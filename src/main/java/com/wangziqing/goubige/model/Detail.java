package com.wangziqing.goubige.model;

import java.sql.Timestamp;

/**
    * details 实体类
    * Mon Jan 18 14:35:24 CST 2016 王梓青
    */ 


public class Detail{
	private int ID;
	private String goodId;
	private String url;
	private String content;
	private byte order;
	private Timestamp creatTime;
	public void setID(int ID){
	this.ID=ID;
	}
	public int getID(){
		return ID;
	}
	public void setGoodId(String goodId){
	this.goodId=goodId;
	}
	public String getGoodId(){
		return goodId;
	}
	public void setUrl(String url){
	this.url=url;
	}
	public String getUrl(){
		return url;
	}
	public void setContent(String content){
	this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setOrder(byte order){
	this.order=order;
	}
	public byte getOrder(){
		return order;
	}
	public void setCreatTime(Timestamp creatTime){
	this.creatTime=creatTime;
	}
	public Timestamp getCreatTime(){
		return creatTime;
	}
}

