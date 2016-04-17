package com.wangziqing.goubige.springMVC.utils;

import com.google.common.base.Optional;
import com.wangziqing.goubige.magic.util.MyStringUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;

import javax.servlet.ServletConfig;

/**
 * Created by WZQ_PC on 2016/3/6 0006.
 */
public class FilesUtils {
    private static final String TAG = "FilesUtils";

    private String resourseDir;

    public String getResourseDir() {
        return resourseDir;
    }

    private static String imageDir="E:\\Intellij IDEA Workbench\\goubige\\WebContent\\resourse\\image";

    public static String getImageDir() {
        return imageDir;
    }
//这里是查找类路径，修改直接保存到地址
    private FilesUtils() {
        try {
            resourseDir = FilesUtils.class.getResource("").toURI().getPath();

            resourseDir = MyStringUtil.getSplitString(resourseDir, "classes", 0)
                    + "resourse";
            imageDir = resourseDir + "/image";
            creatDir(resourseDir);
            creatDir(imageDir);
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static FilesUtils getFileutils() {
        if (null == fileutils) {
            fileutils = new FilesUtils();
        }
        return fileutils;
    }

    private static FilesUtils fileutils;

    private static File creatDir(String dir) {
        File f = new File(dir);
        if (!f.exists()) {
            f.mkdir();
        }
        return f;
    }

    private static File creatFile(String filename, String dir) {
        File f = new File(dir, filename);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (IOException io) {
        }
        return f;
    }

//    public boolean saveFile(File file, String fileName, String dir) {
//        Optional<File> optional = Optional.fromNullable(file);
//        byte[] data = new byte[1024];
//        try (OutputStream outputStream = new BufferedOutputStream(
//                new FileOutputStream(creatFile(fileName, dir)));
//             InputStream inputStream = new BufferedInputStream(
//                     new FileInputStream((File) optional.get()))) {
//            while (inputStream.read(data) != -1) {
//                outputStream.write(data);
//            }
//            return true;
//        } catch (Exception e) {
//            // TODO: handle exception
//            System.out.println(e.getMessage());
//            return false;
//        }
//
//    }

    public boolean saveFile(InputStream file, String fileName, String dir) {
        System.out.println("保存"+fileName+"到"+dir);
        Optional<InputStream> optional = Optional.fromNullable(file);
        byte[] data = new byte[1024];
        try (OutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream(creatFile(fileName, dir)));
             InputStream inputStream = new BufferedInputStream(
                     (InputStream) optional.get())) {
            while (inputStream.read(data) != -1) {
                outputStream.write(data);
            }
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static void main(String[] args) {
        getFileutils();
//    	getFileutils().saveFile(
//    			new File("D:\\青梓\\桌面\\项目\\test1.txt"), 
//    			"test2.txt", 
//    			"D:\\青梓\\桌面\\项目");
    }
}
