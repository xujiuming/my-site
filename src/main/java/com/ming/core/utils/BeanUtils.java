package com.ming.core.utils;

import org.springframework.util.Assert;

public class BeanUtils {

    public static <T> T copy(Object source, Class<T> targetClass) {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(targetClass, "Target Class must not be null");
        try {
            T targetObj = targetClass.getDeclaredConstructor().newInstance();
            org.springframework.beans.BeanUtils.copyProperties(source, targetObj);
            return targetObj;
        } catch (Exception e) {
            throw new RuntimeException("属性复制异常!" + e.getMessage());
        }
    }

    public static <T> T copy(Object source, T target) {
        org.springframework.beans.BeanUtils.copyProperties(source, target);
        return target;
    }

    private BeanUtils() {
    }
}
