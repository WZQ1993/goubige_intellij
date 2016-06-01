package com.wangziqing.goubige.springMVC.utils;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by WZQ_PC on 2016/5/30 0030.
 */
public class RecommentUtils {
    public static int[] getCountList(int num){
        int[] count=new int[num+1];
        int size=20;
        for(int i=0;i<=num;i++){
            if(i==num)count[i]=size;
            else{
                count[i]=size/((num+1)/1);
                size=size-count[i];
            }
        }
        return count;
    }
    public static void main(String[]args){
        for (int i:getCountList(0)
             ) {
            System.out.print(i+"-");
        }
    }
}
