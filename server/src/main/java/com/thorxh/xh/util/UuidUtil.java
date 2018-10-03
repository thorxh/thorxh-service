package com.thorxh.xh.util;

import java.util.UUID;

/**
 * created on 2018/10/3
 *
 * @author thorxh
 */
public class UuidUtil {

    public static String getUUIDStr() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

}
