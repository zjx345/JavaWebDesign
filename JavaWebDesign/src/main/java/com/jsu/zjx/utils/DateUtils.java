package com.jsu.zjx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd";
    public static String format(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
        String dateStr = sdf.format(date);
        return dateStr;
    }
}
