package com.wangziqing.goubige.magic.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ImageDownload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> urls=new ArrayList<>();
		for(int i=0;i<50;i++){
			urls.add("s1.juancdn.com/bao/160112/d/3/569468f592be594c148b4567_400x400.jpg_285x285.jpg");
		}
//		System.out.println(urls.size());
		downloadImage(urls);
	}
	/**
	 * 使用fork/join框架批量下载图片
	 * @param urls
	 */
	public static void downloadImage(List<String> urls){
		ForkJoinPool pool=new ForkJoinPool();
		pool.invoke(new DownloadTask(urls));
		pool.shutdown();
	}

}
/**
 * 
 */
class DownloadTask extends RecursiveAction{
	private static final long serialVersionUID = 1L;
	private List<String> urls=new ArrayList<String>();
	private URL url=null;
	//文件保存目录
	public static final String FILE_DIR="/home/wzq/项目开发/TEST/";
	public DownloadTask(List<String> urls) {
		// TODO Auto-generated constructor stub
		this.urls=urls;
	}
	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		if(urls.size()<=50){
			for (String urlString : urls) {
				try {  
	                url = new URL("http://"+urlString); 
	                DataInputStream dataInputStream = new DataInputStream(url.openStream());  
	                String imageName =urlString;  
	                FileOutputStream fileOutputStream = new FileOutputStream(new File
	                		(FILE_DIR+MyStringUtil.getSplitString(urlString, "/", 5)));  
	                byte[] buffer = new byte[1024];  
	                int length;  
	                while ((length = dataInputStream.read(buffer)) > 0) {  
	                    fileOutputStream.write(buffer, 0, length);  
	                }  
	                dataInputStream.close();  
	                fileOutputStream.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
			}
		}else{
			List<String>[] urls_array=MyCollections.splitCollection(urls, 2);
			DownloadTask T1=new DownloadTask(urls_array[0]),
									   T2=new DownloadTask(urls_array[1]);
			invokeAll(T1, T2);
		}
	}
	
}
