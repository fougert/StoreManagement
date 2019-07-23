package com.rehoshi.util;

import java.util.Collection;

public class CollectionUtil {
    public interface Customer<T>{
        void custom(T data) ;
    }

    public static boolean isNullOrEmpty(Collection collection){
        return collection == null || collection.isEmpty() ;
    }

    public static <T> void foreach(Collection<T> collection, Customer<T> customer){
        if(!isNullOrEmpty(collection)){
            for (T data : collection){
                customer.custom(data);
            }
        }
    }
}
