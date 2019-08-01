package com.rehoshi.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtil {
    public interface Customer<T> {
        void custom(T data);
    }

    public interface Mapper<T, R> {
        R map(T data);
    }

    public static boolean isNullOrEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> void foreach(Collection<T> collection, Customer<T> customer) {
        if (!isNullOrEmpty(collection)) {
            for (T data : collection) {
                customer.custom(data);
            }
        }
    }

    public static <T, R> List<R> map(Collection<T> collection, Mapper<T, R> mapper) {
        List<R> list = new ArrayList<>();
        if (!isNullOrEmpty(collection)) {
            for (T data : collection) {
                R map = mapper.map(data);
                list.add(map);
            }
        }
        return list;
    }
}
