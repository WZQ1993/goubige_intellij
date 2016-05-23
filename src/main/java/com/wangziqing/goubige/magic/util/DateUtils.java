package com.wangziqing.goubige.magic.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by WZQ_PC on 2016/5/23 0023.
 */
public class DateUtils {
    //    private static String ymdhms = "yyyy-MM-dd HH:mm:ss";
    private static String ymd = "yyyy-MM-dd";
    private static SimpleDateFormat ymdSDF = new SimpleDateFormat(ymd);

    //    private static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat(ymdhms);
    public static String getNow() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return ymdSDF.format(calendar.getTime());
    }

    public static String getPreDate(String time) {
        String result="";
        try {
            Date date= ymdSDF.parse(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            date = calendar.getTime();
            result=ymdSDF.format(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return result;

    }

    public static void main(String[] args) {
//        String now = DateUtils.getNow();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(now);
//            now = DateUtils.getPreDate(now);
//        }
        String str="https://api.smzdm.com/v1/youhui/articles/?category=163&article_date=2016-04-23";
        Pattern p = Pattern.compile("(.+)category=(\\d+)&(.+)");
        Matcher m = p.matcher(str);
        m.find();
        System.out.print(m.group(2));
    }
}
