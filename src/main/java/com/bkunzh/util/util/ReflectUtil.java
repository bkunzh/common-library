package com.bkunzh.util.util;

import java.lang.reflect.Field;

/**
 * Created by bkunzhang on 2019/8/2.
 */
public class ReflectUtil {

    public static Object getFieldValue(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        return getFieldValue(obj, obj.getClass().getDeclaredField(fieldName));
    }

    public static Object getFieldValue(Object obj, Field field) throws IllegalAccessException {
        if (field.getDeclaringClass() != obj.getClass()) {
            throw new IllegalArgumentException("field not in obj class");
        }
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static void setFieldValue(Object obj, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        setFieldValue(obj, obj.getClass().getDeclaredField(fieldName), value);
    }
    
    public static void setFieldValue(Object obj, Field field, Object value) throws IllegalAccessException {
        if (field.getDeclaringClass() != obj.getClass()) {
            throw new IllegalArgumentException("field not in obj class");
        }
        field.setAccessible(true);
        field.set(obj, value);
    }
}
