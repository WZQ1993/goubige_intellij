package com.wangziqing.goubige.springMVC.utils;

/**
 * Created by WZQ_PC on 2016/5/27 0027.
 */
public class LangsUtils {
    public static int parseInt(String value,Integer defaultValue){
        int result=defaultValue==null?0:defaultValue;
        if(null!=value&&!"".equals(value)){
            try{
                result=Integer.valueOf(value);
            }catch (Exception e){
                return result;
            }
        }
        return result;
    }

}
