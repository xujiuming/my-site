package com.ming.core.utils;

import java.util.Collection;
import java.util.Map;

public class CollectionUtils {

    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    public static <T> boolean notEmpty(T[] array) {
        return !isEmpty(array);
    }

    public static <T> boolean isEmpty(Collection<T> collection) {
        return org.springframework.util.CollectionUtils.isEmpty(collection);
    }

    public static <T> boolean notEmpty(Collection<T> collection) {
        return !isEmpty(collection);
    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return org.springframework.util.CollectionUtils.isEmpty(map);
    }

    public static <K, V> boolean notEmpty(Map<K, V> map) {
        return !isEmpty(map);
    }


    private CollectionUtils() {
    }
}
