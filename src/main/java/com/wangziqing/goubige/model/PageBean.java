package com.wangziqing.goubige.model;

public class PageBean { 
    //开始数 
    private Integer startRow; 
    //结束数 
    private Integer pageSize; 
       
    public PageBean(){ 
           
    } 
    public PageBean(Integer startNumber, Integer endNumber) { 
        super(); 
        this.startRow = startNumber; 
        this.pageSize = endNumber; 
    } 
    public Integer getStartNumber() { 
        return startRow; 
    } 
    public void setStartNumber(Integer startNumber) { 
        this.startRow = startNumber; 
    } 
    public Integer getEndNumber() { 
        return pageSize; 
    } 
    public void setEndNumber(Integer endNumber) { 
        this.pageSize = endNumber; 
    } 
}