package com.rehoshi.util;

public class StringUtil {
    public static boolean isNullOrEmpty(String str){
        return str == null || str.trim().length() == 0;
    }
}
