package com.thorxh.xh.util;

import com.google.common.base.Preconditions;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * created on 2018/10/2
 * 对象转换器：
 *     完成各种对象之间的转换
 * @author thorxh
 */
@Log4j2
public class ObjectConverter {

    private static  final Map<Class, Field[]> classFieldsMap = new ConcurrentHashMap<>();

    public static <F, T> List<T> simpleConvert(List<F> objs, Class<T> toClazz) {
        if (CollectionUtils.isEmpty(objs)) {
            return Collections.emptyList();
        }
        List<T> tList = new LinkedList<>();
        for (F obj : objs) {
            tList.add(simpleConvert(obj, toClazz));
        }
        return tList;
    }

    public static  <F, T> T simpleConvert(F obj, Class<T> toClazz) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(toClazz);

        Class<?> objClass = obj.getClass();
        Field[] fields = getClassFields(objClass);
        if (fields == null) {
            return null;
        }

        Field[] toFields = getClassFields(toClazz);
        if (toFields == null) {
            return null;
        }

        Map<String, Field> toFieldMap = new HashMap<>();
        for (Field toField : toFields) {
            toFieldMap.put(toField.getName(), toField);
        }

        T instance;
        try {
            instance = toClazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("an exception occur when get instance of " + toClazz.getName(), e);
            return null;
        }

        for (Field field : fields) {
            String name = field.getName();
            Field to = toFieldMap.get(name);
            if (to == null) {
                continue;
            }
            field.setAccessible(true);
            try {
                to.setAccessible(true);
                // 将时间转为时间戳
                if (isTimeType(field.getType()) && isLongType(to.getType())) {
                    Object value = field.get(obj);
                    if (value != null) {
                        to.set(instance, ((Date) value).getTime());
                    }
                } else {
                    to.set(instance, field.get(obj));
                }
            } catch (IllegalAccessException e) {
                log.error("an exception occur when get value of " + field, e);
            }
        }

        return instance;
    }

    private static Field[] getClassFields(Class clazz) {
        if (clazz == null) {
            return null;
        }

        Field[] fields = classFieldsMap.get(clazz);
        if (fields == null) {
            synchronized (classFieldsMap) {
                if ((fields = classFieldsMap.get(clazz)) == null) {
                    fields = clazz.getDeclaredFields();
                    classFieldsMap.put(clazz, fields);
                }
            }
        }

        return fields;
    }

    private static boolean isTimeType(Class clazz) {
        return java.util.Date.class.equals(clazz) ||
                java.sql.Date.class.equals(clazz) ||
                java.sql.Timestamp.class.equals(clazz) ||
                java.sql.Time.class.equals(clazz);
    }

    private static boolean isLongType(Class clazz) {
        return java.lang.Long.class.equals(clazz);
    }

}