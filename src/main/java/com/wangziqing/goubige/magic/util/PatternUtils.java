package com.wangziqing.goubige.magic.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by WZQ_PC on 2016/5/23 0023.
 */
public class PatternUtils {
    private static final Pattern p = Pattern.compile("(.+)category=(\\d+)&(.+)");
    public static int getCategoryFromUrl(String url){
        Matcher m = p.matcher(url);
        m.find();
        return Integer.valueOf(m.group(2));
    }
}
