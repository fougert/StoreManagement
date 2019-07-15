package com.rehoshi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static SimpleDateFormat dateFormat ;

    private static SimpleDateFormat getDateFormat(){
        if(dateFormat == null){
            dateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
        }
        return dateFormat ;
    }

    public static String formatDate(Date date){
        return formatDate("yyyy-MM-dd", date) ;
    }

    public static String formatDate(String pattern, Date date){
        getDateFormat().applyPattern(pattern) ;
        return date == null ? "" : getDateFormat().format(date) ;
    }
}
