package com.wangziqing.goubige.magic.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Multiset.Entry;

public class MyCollections {
	private MyCollections(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l=new ArrayList<>();
		for(int i=0;i<10;i++){
			l.add(""+i);
		}
		List<String>[] l_array=splitCollection(l, 2);
		
	}
	public static <T> String printfCollection(Collection<T> c){
		StringBuilder result=new StringBuilder("[");
		Iterator<T> i=c.iterator();
		while(i.hasNext()){
			result.append(i.next().toString()+",");
		}
		result.append("]");
		System.out.println(result.toString());
		return result.toString();
	}
	public static <K,V> String printfMap(Map<K,V> m){
		StringBuilder result=new StringBuilder("[");
		for (K k: m.keySet()) {
			result.append(k.toString()+":"+m.get(k).toString()+",");
		}
		result.append("]");
		System.out.println(result.toString());
		return result.toString();
	}
	
	public static <T> List<T>[] splitCollection(List<T> l,int total){
		int sum=l.size()/total;
		List<T>[] result=new ArrayList[total];
		int index=0;
		List<T> item=null;
		for(int i=0;i<l.size();){
			if(i%sum==0){
				item=new ArrayList<>();
			}
			item.add(l.get(i));
			i++;
			if(i%sum==0){
				result[index]=item;
				index++;
			}
		}
		return result;
	}
}
