package com.message.utils;

import com.mysql.jdbc.StringUtils;
import com.sun.org.apache.regexp.internal.RE;

/**
 * describe:
 *
 * @author Liu
 * @since 2018/08/30
 */


public class LevelUtils {

    public static final String SPLIT_KEY = "-";


    //生成level规则
    public static String factoryLevel(String parentLevel, Integer parentId) {
        if (parentId == 0) {
            return "0";
        } else {
            return parentLevel + SPLIT_KEY + parentId;
        }
    }
}
